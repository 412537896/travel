package com.weiminw.business.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.weiminw.travel.interfaces.IRoomType;
import com.weiminw.travel.interfaces.managers.IRoomTypeManager;
import com.weiminw.travel.persistence.IPersistence;
import com.weiminw.travel.persistence.impls.MySqlPersistence;
import com.weiminw.travel.persistence.impls.pos.HotelEntity;
import com.weiminw.travel.persistence.impls.pos.RoomTypePO;

public class RoomTypeManager implements IRoomTypeManager {

	final static MySqlPersistence<RoomTypePO> persistence = MySqlPersistence.create();

	private RoomTypeManager() {
	}
	@Override
	public IRoomType getRoomTypeById(long id) {
		return persistence.getPersistenceObject(RoomTypePO.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IRoomType> getRoomTypeByHotelId(long hid) {
//		EntityManager manager = factory.createEntityManager();
//		Query namedQuery= manager.createNamedQuery("RoomType.findByHid");
//		namedQuery.setParameter("hid", hid);
//		persistence.
//		return namedQuery.getResultList();
		return null;
	}
	public final static RoomTypeManager newInstance(){
		return new RoomTypeManager();
	}

}
