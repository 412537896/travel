package test.com.weiminw.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.weiminw.business.aos.Hotel;
import com.weiminw.business.managers.HotelManager;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IHotelManager;
import com.weiminw.travel.persistence.impls.pos.HotelEntity;

public class TestHotelManager {
	IHotelManager manager = HotelManager.create();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetHotelById() {
		IHotel hotel =  this.manager.getHotelById(1000442L);
		Assert.assertNotNull(hotel);
	}
	@Test
	public void testGetHotels() {
		fail("Not yet implemented");
	}



	@Test
	public void testUpdateHotel(){
		IHotel hotel =  this.manager.getHotelById(10000893);
		hotel = Hotel.builder(hotel).longitude(2D).build();
		this.manager.updateHotel(hotel);
		IHotel nhotel = this.manager.getHotelById(10000893);
		System.out.println(nhotel);
		Assert.assertEquals(nhotel.getLongitude(), 2D);
	}
}
