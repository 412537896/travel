package com.weiminw.business.managers;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.weiminw.business.aos.Seller;
import com.weiminw.business.trans.UserTransform;
import com.weiminw.travel.interfaces.IUser;
import com.weiminw.travel.interfaces.IUserManager;
import com.weiminw.travel.persistence.impls.MySqlPersistence;
import com.weiminw.travel.persistence.impls.pos.SellerEntity;

public final class UserManager implements IUserManager{
	final static MySqlPersistence<SellerEntity> persistence = MySqlPersistence.create();
	public static IUserManager create() {
		// TODO Auto-generated method stub
		return new UserManager();
	}
	@Override
	public IUser getUserById(long id) {
		return IUser.NONE;
//		return Optional.fromNullable(persistence.getPersistenceObject(UserPO.class, id)).or(IUser.NULL);
	}
	
	@Override
	public List<IUser> getSellerByHid(long id) {
		// TODO Auto-generated method stub
		Map.Entry<String,Long> queryParameters = Maps.immutableEntry("hid", id);
		List<SellerEntity> entities = persistence.getPersistenceObjects("SellerEntity.findAllByHid", queryParameters);
		return ImmutableList.copyOf(Collections2.transform(entities, UserTransform.SellerEntity2Seller()));
	}

	/*@Override
	public List<IUser> getSellerByLntLat(double lnt, double lat) {
		// TODO Auto-generated method stub
		double minLnt = lnt - 1;
		double maxLnt = lnt + 1;
		double minLat  = lat - 1;
		double maxLat = lat + 1;
		List<IUser> sellers = persistence.getPersistenceObjects("UserPO.findAllByLntLat",
				Maps.immutableEntry("1", minLnt),
				Maps.immutableEntry("2", maxLnt),
				Maps.immutableEntry("3", minLat),
				Maps.immutableEntry("4", maxLat)
		);
		return sellers;
	}*/
//	@Override
//	public IUser addUser(IUser user) {
//		// TODO Auto-generated method stub
//		UserPO po = Optional.fromNullable(user).transform(UserTransform.User2UserEntity()).or(new UserPO());
//		persistence.insertPersistenceObjects(po);
//		return po;
//	}
	@Override
	public IUser addSeller(IUser user) {
		// TODO Auto-generated method stub
		Preconditions.checkNotNull(user);
		Seller seller = (Seller)user;
		SellerEntity entity = Optional.of(seller).transform(UserTransform.Seller2SellerEntity()).get();
		boolean success = this.persistence.insertPersistenceObjects(entity);
		return  Optional.of(entity).transform(UserTransform.SellerEntity2Seller()).get();
		
	}
	
	

}
