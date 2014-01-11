package com.weiminw.business.managers;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;












import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Doubles;
import com.weiminw.business.aos.Hotel;
import com.weiminw.business.exceptions.IllegalArgumentExceptionEnum;
import com.weiminw.business.spatial.HotelSpatial;
import com.weiminw.business.trans.HotelTransform;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IHotelLocation;
import com.weiminw.travel.interfaces.IHotelManager;
import com.weiminw.travel.persistence.impls.MySqlPersistence;
import com.weiminw.travel.persistence.impls.pos.HotelEntity;

public class HotelManager implements IHotelManager {
	private final static MySqlPersistence<HotelEntity> persistence = MySqlPersistence.create();
	private Logger logger = LogManager.getLogger(HotelManager.class);
	
//	/**
//	 * 过滤半径5公里的酒店
//	 *
//	 */
//	private static final Predicate<IHotel> FilterHotelPredicate = new Predicate<IHotel>() {
//		@Override
//		public boolean apply(IHotel input) {
//			return input.getDistance() <= 5000;
//		}
//	};
//	/**
//	 * 按距离排序
//	 */
//	private static final Comparator<IHotel> comparator = new Comparator<IHotel> (){
//		@Override
//		public int compare(IHotel o1, IHotel o2) {
//			return Doubles.compare(o1.getDistance(), o2.getDistance());
//		}
//		
//	};
	
	
		
	/**
	 * 通过酒店ID获取酒店信息
	 */
	@Override
	public IHotel getHotelById(long id) {
		Preconditions.checkArgument(id>0,IllegalArgumentExceptionEnum.ID_INVALID.getMessage());
		
		return Optional.fromNullable(persistence.getPersistenceObject(HotelEntity.class, id)).transform(HotelTransform.HotelEntity2Hotel()).or(IHotel.NULL);
	}
	
	/**
	 * 获取全部酒店
	 */
	@Override
	public List<IHotel> getHotels() {
		List<HotelEntity> databaseResult = this.persistence.getPersistenceObjects("HotelEntity.findAll");
		return ImmutableList.copyOf(Collections2.transform(databaseResult, HotelTransform.HotelEntity2Hotel()));
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
//	@Override
//	public List<IHotel> getHotelsByLntLat(final double lnt, final double lat) {
//		Map.Entry<String, Double> minLntParam = Maps.immutableEntry("minLnt", lnt - 0.05);
//		Map.Entry<String, Double> maxLntParam = Maps.immutableEntry("maxLnt", lnt + 0.05);
//		Map.Entry<String, Double> minLatParam = Maps.immutableEntry("minLat", lat - 0.05);
//		Map.Entry<String, Double> maxLatParam = Maps.immutableEntry("maxLat", lat + 0.05);
//		List<IHotel> hotels = persistence.getPersistenceObjects("HotelEntity.findPOI",
//				minLntParam,
//				maxLntParam,
//				minLatParam,
//				maxLatParam
//				);
//		logger.debug(hotels.size());
//		List<IHotel> filteredHotels = FluentIterable.from(hotels).transform(Hotel.getHotelTrans( lnt, lat)).filter(FilterHotelPredicate).toSortedList(comparator);
//		logger.debug(filteredHotels.size());
//		return FluentIterable.from(filteredHotels).limit(20).toList();
//	}
//

	@Override
	public boolean updateHotel(IHotel hotel) {
		HotelEntity hotelPO = Optional.fromNullable(hotel).transform(HotelTransform.Hotel2HotelEntity()).or(new HotelEntity());
		return this.persistence.updatePersistenceObject(hotelPO);
	}

	@Override
	public List<IHotelLocation> getHotelsByLntLat(double lnt, double lat, int start) {
		
			List<Long> ids = HotelSpatial.search(lnt, lat, 5);
			int size = Math.min(50, ids.size());
			List<IHotel> hotels = Lists.newArrayListWithCapacity(size);
			for(long id:ids.subList(0, size)){
				hotels.add(this.getHotelById(id));
			}
			List<IHotelLocation> hotelsLocation = FluentIterable.from(hotels).transform(HotelTransform.Hotel2HotelLocation()).toList();
			return hotelsLocation;
		
	}

}
