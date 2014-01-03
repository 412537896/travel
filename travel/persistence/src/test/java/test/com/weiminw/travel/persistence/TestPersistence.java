package test.com.weiminw.travel.persistence;

import static org.junit.Assert.*;

import org.junit.Test;

import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.persistence.IPersistence;
import com.weiminw.travel.persistence.impls.MySqlPersistence;
import com.weiminw.travel.persistence.impls.pos.HotelPO;

public class TestPersistence {
	IPersistence<IHotel> persistence = MySqlPersistence.create();
	@Test
	public void testGetPersistenceObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPersistenceObjectsString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPersistenceObjectsStringEntryOfStringQArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertPersistenceObjects() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdatePersistenceObject() {
		HotelPO po = (HotelPO) persistence.getPersistenceObject(HotelPO.class, 10000893L);
		po.setLongtitude(1);
		this.persistence.updatePersistenceObject(po);
		
	}

}
