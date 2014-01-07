package test.com.weiminw.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.weiminw.business.managers.UserManager;
import com.weiminw.travel.interfaces.IUser;
import com.weiminw.travel.interfaces.IUserManager;

public class TestUserManager {
	IUserManager manager = new UserManager();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetUserById() {
		IUser user = manager.getUserById(1);
		Assert.assertNotEquals(user, IUser.NONE);
	}

	@Test
	public void testGetUserByHid() {
		List<IUser> user = manager.getSellerByHid(10000442);
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.size()>0);
	}
//	@Test
//	public void testGetSellerByLntLat(){
//		List<IUser> users = manager.getSellerByLntLat(116.406887,39.98207);
//		Assert.assertNotNull(users);
//		System.out.println(users);
//	}

}

