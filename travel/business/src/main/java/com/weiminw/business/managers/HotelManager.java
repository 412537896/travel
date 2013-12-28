package com.weiminw.business.managers;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Doubles;
import com.weiminw.business.aos.Hotel;
import com.weiminw.business.exceptions.IllegalArgumentExceptionEnum;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IHotelManager;
import com.weiminw.travel.persistence.impls.MySqlPersistence;
import com.weiminw.travel.persistence.impls.pos.HotelPO;
import com.weiminw.travel.utils.LntLatCaculator;

public class HotelManager implements IHotelManager {
	private final static MySqlPersistence<HotelPO> persistence = MySqlPersistence.create();
	private Logger logger = Logger.getLogger(HotelManager.class);
	/**
	 * 过滤半径5公里的酒店
	 *
	 */
	private static final Predicate<IHotel> FilterHotelPredicate = new Predicate<IHotel>() {
		@Override
		public boolean apply(IHotel input) {
			return input.getDistance() <= 5000;
		}
	};
	/**
	 * 按距离排序
	 */
	private static final Comparator<IHotel> comparator = new Comparator<IHotel> (){
		@Override
		public int compare(IHotel o1, IHotel o2) {
			return Doubles.compare(o1.getDistance(), o2.getDistance());
		}
		
	};
		
	/**
	 * 通过酒店ID获取酒店信息
	 */
	@Override
	public IHotel getHotelById(long id) {
		Preconditions.checkArgument(id>0,IllegalArgumentExceptionEnum.ID_INVALID.getMessage());
		return persistence.getPersistenceObject(HotelPO.class, id);
	}
	
	/**
	 * 获取全部酒店
	 */
	@Deprecated
	@Override
	public List<IHotel> getHotels() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 创建HotelManager实例
	 * @return
	 */
	public final static IHotelManager create() {
		// TODO Auto-generated method stub
		return new HotelManager();
	}
	
	/**
	 * 根据经纬度获取酒店信息
	 */
	@Override
	public List<IHotel> getHotelsByLntLat(final double lnt, final double lat) {
		Map.Entry<String, Double> minLntParam = Maps.immutableEntry("minLnt", lnt - 0.05);
		Map.Entry<String, Double> maxLntParam = Maps.immutableEntry("maxLnt", lnt + 0.05);
		Map.Entry<String, Double> minLatParam = Maps.immutableEntry("minLat", lat - 0.05);
		Map.Entry<String, Double> maxLatParam = Maps.immutableEntry("maxLat", lat + 0.05);
		List<HotelPO> hotels = persistence.getPersistenceObjects("HotelPO.findPOI",
				minLntParam,
				maxLntParam,
				minLatParam,
				maxLatParam
				);
		logger.debug(hotels.size());
		List<IHotel> filteredHotels = FluentIterable.from(hotels).transform(Hotel.getHotelTrans( lnt, lat)).filter(FilterHotelPredicate).toSortedList(comparator);
		logger.debug(filteredHotels.size());
		return FluentIterable.from(filteredHotels).limit(20).toList();
		
	}

}
