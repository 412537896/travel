package com.weiminw.travel.persistence.impls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.weiminw.travel.interfaces.IRoomType;
import com.weiminw.travel.interfaces.IRoomTypeManager;
import com.weiminw.travel.persistence.IPersistence;
import com.weiminw.travel.persistence.impls.pos.RoomTypePO;

public class RoomTypeManager implements IRoomTypeManager {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("travel");

	public RoomTypeManager() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public IRoomType getRoomTypeById(long id) {
		EntityManager manager = factory.createEntityManager();
		return manager.find(RoomTypePO.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IRoomType> getRoomTypeByHotelId(long hid) {
		// TODO Auto-generated method stub
		EntityManager manager = factory.createEntityManager();
		Query namedQuery= manager.createNamedQuery("RoomType.findByHid");
		namedQuery.setParameter("hid", hid);
		return namedQuery.getResultList();
	}

}
