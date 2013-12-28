package com.weiminw.travel.interfaces;

import java.util.Collection;
import java.util.List;

public interface IUserManager {
	public IUser getUserById(long id);
	public List<IUser> getUserByHid(long id);
	public List<IUser> getSellerByLntLat(double lnt,double lat);
	
}
