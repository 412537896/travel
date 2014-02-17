/**
 * 
 */
package test.com.weiminw.travel.persistence;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.weiminw.travel.dao.impls.HotelManager;
import com.weiminw.travel.interfaces.daos.IHotel;
import com.weiminw.travel.interfaces.daos.IHotelLocation;

/**
 * @author william.wangwm
 *
 */
public class TestHotelDAO {
	HotelManager dao = HotelManager.create();
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.weiminw.travel.dao.impls.HotelManager#getHotelById(long)}.
	 */
	@Test
	public void testGetHotelById() {
		IHotel hotel = dao.getHotelById(10000442L);
		System.out.println(hotel.getName());
	}

	/**
	 * Test method for {@link com.weiminw.travel.dao.impls.HotelManager#getHotels()}.
	 */
	@Test
	public void testGetHotels() {
		List<IHotelLocation> hotels = dao.getHotels();
		System.out.println(hotels.size());
	}

	/**
	 * Test method for {@link com.weiminw.travel.dao.impls.HotelManager#updateHotel(com.weiminw.travel.interfaces.daos.IHotel)}.
	 */
	@Test
	public void testUpdateHotel() {
		fail("Not yet implemented");
	}

}
