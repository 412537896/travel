package test.com.weiminw.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.weiminw.business.HotelManager;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IHotelManager;

public class TestHotelManager {
	IHotelManager manager = HotelManager.newInstance();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetHotelById() {
		IHotel hotel =  this.manager.getHotelById(10000442L);
		Assert.assertNotNull(hotel);
	}
	@Test
	public void testGetHotels() {
		fail("Not yet implemented");
	}


	@Test
	public void testGetHotelsByLntLat() {
		List<IHotel> hotel =  this.manager.getHotelsByLntLat(116,39);
		System.out.println(hotel.size());
	}

}
