package test.com.weiminw.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.weiminw.business.UserManager;
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
		Assert.assertNotEquals(user, IUser.NULL);
	}

	@Test
	public void testGetUserByHid() {
		List<IUser> user = manager.getUserByHid(10000442);
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.size()>0);
	}

}
