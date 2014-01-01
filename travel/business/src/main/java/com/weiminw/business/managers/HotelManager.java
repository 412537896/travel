package com.weiminw.business.managers;

import java.util.Comparator;
import java.util.List;
import java.util.Map;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Maps;
import com.google.common.primitives.Doubles;
import com.weiminw.business.aos.Hotel;
import com.weiminw.business.exceptions.IllegalArgumentExceptionEnum;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IHotelManager;
import com.weiminw.travel.persistence.impls.MySqlPersistence;
import com.weiminw.travel.persistence.impls.pos.HotelPO;

public class HotelManager implements IHotelManager {
	private final static MySqlPersistence<IHotel> persistence = MySqlPersistence.create();
	private Logger logger = LogManager.getLogger(HotelManager.class);
	
	/**
	 * ���˰뾶5����ľƵ�
	 *
	 */
	private static final Predicate<IHotel> FilterHotelPredicate = new Predicate<IHotel>() {
		@Override
		public boolean apply(IHotel input) {
			return input.getDistance() <= 5000;
		}
	};
	/**
	 * ����������
	 */
	private static final Comparator<IHotel> comparator = new Comparator<IHotel> (){
		@Override
		public int compare(IHotel o1, IHotel o2) {
			return Doubles.compare(o1.getDistance(), o2.getDistance());
		}
		
	};
	
	
		
	/**
	 * ͨ���Ƶ�ID��ȡ�Ƶ���Ϣ
	 */
	@Override
	public IHotel getHotelById(long id) {
		Preconditions.checkArgument(id>0,IllegalArgumentExceptionEnum.ID_INVALID.getMessage());
		return persistence.getPersistenceObject(HotelPO.class, id);
	}
	
	/**
	 * ��ȡȫ���Ƶ�
	 */
	@Override
	public List<IHotel> getHotels() {
		return this.persistence.getPersistenceObjects("HotelPO.findAll");
	}
	/**
	 * ����HotelManagerʵ��
	 * @return
	 */
	public final static IHotelManager create() {
		// TODO Auto-generated method stub
		return new HotelManager();
	}
	
	/**
	 * ���ݾ�γ�Ȼ�ȡ�Ƶ���Ϣ
	 */
	@Override
	public List<IHotel> getHotelsByLntLat(final double lnt, final double lat) {
		Map.Entry<String, Double> minLntParam = Maps.immutableEntry("minLnt", lnt - 0.05);
		Map.Entry<String, Double> maxLntParam = Maps.immutableEntry("maxLnt", lnt + 0.05);
		Map.Entry<String, Double> minLatParam = Maps.immutableEntry("minLat", lat - 0.05);
		Map.Entry<String, Double> maxLatParam = Maps.immutableEntry("maxLat", lat + 0.05);
		List<IHotel> hotels = persistence.getPersistenceObjects("HotelPO.findPOI",
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

	@Override
	public List<IHotel> getHotelsByLntLat(double lnt, double lat, int start) {
		// TODO Auto-generated method stub
		return null;
	}

}