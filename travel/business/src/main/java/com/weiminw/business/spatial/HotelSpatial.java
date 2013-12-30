package com.weiminw.business.spatial;

import java.io.IOException;
import java.util.Map;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queries.function.ValueSource;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.spatial.prefix.PrefixTreeStrategy;
import org.apache.lucene.spatial.prefix.RecursivePrefixTreeStrategy;
import org.apache.lucene.spatial.prefix.tree.GeohashPrefixTree;
import org.apache.lucene.spatial.prefix.tree.SpatialPrefixTree;
import org.apache.lucene.spatial.prefix.tree.SpatialPrefixTreeFactory;
import org.apache.lucene.spatial.query.SpatialArgs;
import org.apache.lucene.spatial.query.SpatialOperation;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

import com.google.common.collect.Maps;
import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.distance.DistanceUtils;
import com.spatial4j.core.shape.Point;
import com.spatial4j.core.shape.Shape;


public class HotelSpatial {
	/**
	 * 索引内存
	 */
	private static final RAMDirectory directory = new RAMDirectory();
	private static final SpatialPrefixTree grid;
	private static final PrefixTreeStrategy strategy;
	static {
		Map<String,String> args = Maps.newHashMapWithExpectedSize(3);
		args.put(SpatialPrefixTreeFactory.PREFIX_TREE, GeohashPrefixTree.class.getName());
		args.put(SpatialPrefixTreeFactory.MAX_LEVELS, "12");
		grid = SpatialPrefixTreeFactory.makeSPT(args, SpatialPrefixTreeFactory.class.getClassLoader(), SpatialContext.GEO);
		strategy = new RecursivePrefixTreeStrategy(grid, "myGeoField");
	}
	/**
	 * 初始化索引
	 */
	static {
	    try {
			IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig(Version.LUCENE_46,null));
			indexWriter.addDocument(newSampleDocument(
			        2, SpatialContext.GEO.makePoint(-80.93, 33.77)));

			    //When parsing a string to a shape, the presence of a comma means it's y-x
			    // order (lon, lat)
			    indexWriter.addDocument(newSampleDocument(
			        4, SpatialContext.GEO.readShape("-50.7693246, 60.9289094")));

			    indexWriter.addDocument(newSampleDocument(
			        20, SpatialContext.GEO.makePoint(0.1,0.1), SpatialContext.GEO.makePoint(0, 0)));

			    indexWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Document newSampleDocument(int id, Shape... shapes) {
	    Document doc = new Document();
	    doc.add(new IntField("id", id, Field.Store.YES));
	    //Potentially more than one shape in this field is supported by some
	    // strategies; see the javadocs of the SpatialStrategy impl to see.
	    for (Shape shape : shapes) {
	      for (Field f : strategy.createIndexableFields(shape)) {
	        doc.add(f);
	      }
	      //store it too; the format is up to you
	      doc.add(new StoredField(strategy.getFieldName(), SpatialContext.GEO.toString(shape)));
	    }

	    return doc;
	  }

	
	public static void search(double lnt,double lat,int radius) throws IOException{
		Point pt = SpatialContext.GEO.makePoint(lat, lat);
		double degToM = DistanceUtils.degrees2Dist(1, DistanceUtils.EARTH_MEAN_RADIUS_KM)*1000;
	    ValueSource valueSource = strategy.makeDistanceValueSource(pt, degToM);//the distance (in m)
		IndexReader indexReader = DirectoryReader.open(directory);
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		Sort distSort = new Sort(valueSource.getSortField(false)).rewrite(indexSearcher);//false=asc dist
		SpatialArgs args = new SpatialArgs(SpatialOperation.Intersects, SpatialContext.GEO.makeCircle(lnt, lat, radius));
		Filter filter = strategy.makeFilter(args);
		TopDocs docs = indexSearcher.search(new MatchAllDocsQuery(), filter, 20, distSort);
		System.out.println(docs);
	}
	public static void main(String[] args) throws IOException {
		HotelSpatial.search(1, 1, 2);
	}
}
