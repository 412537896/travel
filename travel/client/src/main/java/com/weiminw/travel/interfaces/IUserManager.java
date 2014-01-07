package com.weiminw.travel.interfaces;

import java.util.Collection;
import java.util.List;

public interface IUserManager {
	public IUser getUserById(long id);
	public List<IUser> getSellerByHid(long id);
//	public List<IUser> getSellerByLntLat(double lnt,double lat);
//	public IUser addUser(IUser user);
	public IUser addSeller(IUser user);
	
}
