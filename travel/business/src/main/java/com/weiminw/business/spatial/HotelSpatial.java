package com.weiminw.business.spatial;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queries.function.ValueSource;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
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

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.distance.DistanceUtils;
import com.spatial4j.core.shape.Point;
import com.spatial4j.core.shape.Shape;
import com.weiminw.business.managers.HotelManager;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IHotelManager;


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
		grid = new GeohashPrefixTree(SpatialContext.GEO, 11);
		strategy = new RecursivePrefixTreeStrategy(grid, "myGeoField");
	}
	
	private static Document createHotelLntLatPoint(IHotel hotel) {
	    Document doc = new Document();
	    doc.add(new LongField("id", hotel.getId(), Field.Store.YES));
	    Shape shape = SpatialContext.GEO.makePoint(hotel.getLongtitude(), hotel.getLatitude());
	    for (Field f : strategy.createIndexableFields(shape)) {
	    	doc.add(f);
	    }
	    return doc;
	  }

	
	public static List<Long> search(double lnt,double lat,int radius) throws IOException{
		Point pt = SpatialContext.GEO.makePoint(lat, lat);
		double degToM = DistanceUtils.degrees2Dist(1, DistanceUtils.EARTH_MEAN_RADIUS_KM);
	    ValueSource valueSource = strategy.makeDistanceValueSource(pt, degToM);//the distance (in m)
		IndexReader indexReader = DirectoryReader.open(directory);
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		Sort distSort = new Sort(valueSource.getSortField(false)).rewrite(indexSearcher);//false=asc dist
		SpatialArgs args = new SpatialArgs(SpatialOperation.Intersects, SpatialContext.GEO.makeCircle(lnt, lat, DistanceUtils.dist2Degrees(radius, DistanceUtils.EARTH_MEAN_RADIUS_KM)));
		Filter filter = strategy.makeFilter(args);
		TopDocs docs = indexSearcher.search(new MatchAllDocsQuery(), filter, 50, distSort);
		List<Long> hotelIds = Lists.newArrayListWithExpectedSize(docs.totalHits);
		for(ScoreDoc doc:docs.scoreDocs){
			hotelIds.add(indexSearcher.doc(doc.doc).getField("id").numericValue().longValue());
		}
		return hotelIds;
	}
	
	public static void main(String[] args) throws IOException {
		List<Long> ids = HotelSpatial.search(116.406887,39.98207, 2000000);
		System.out.println(ids.toString());
	}
	
	/**
	 * 初始化索引
	 */
	public static void buildIndex(List<IHotel> hotels) {
		try {
	    	IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig(Version.LUCENE_46,null));
	    	for(IHotel hotel:hotels){
	    		indexWriter.addDocument(createHotelLntLatPoint(hotel));
	    	}

			indexWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
