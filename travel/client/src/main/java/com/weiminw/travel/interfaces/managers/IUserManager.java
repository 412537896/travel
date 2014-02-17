package com.weiminw.travel.interfaces.managers;

import java.util.Collection;
import java.util.List;

import com.weiminw.travel.interfaces.daos.IUser;

public interface IUserManager {
	public IUser getUserById(long id);
	public List<IUser> getSellerByHid(long id);
//	public List<IUser> getSellerByLntLat(double lnt,double lat);
	public IUser addUser(IUser user);
	public IUser addSeller(IUser user);
	
}
