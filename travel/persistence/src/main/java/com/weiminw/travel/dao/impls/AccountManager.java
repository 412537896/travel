package com.weiminw.travel.dao.impls;

import java.util.List;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.weiminw.travel.dao.impls.pos.SellerEntity;
import com.weiminw.travel.dao.impls.pos.UserEntity;
import com.weiminw.travel.dao.utils.AccountEntityTrans;
import com.weiminw.travel.interfaces.daos.IUser;
import com.weiminw.travel.interfaces.managers.IUserManager;

public class AccountManager implements IUserManager {
	private final static MySqlPersistence<UserEntity> userPersistence =MySqlPersistence.create();
	private final static MySqlPersistence<SellerEntity> sellerPersistence =MySqlPersistence.create();
	private final static AccountManager manager = new AccountManager();
	@Override
	public IUser getUserById(long id) {
		UserEntity entity = userPersistence.getPersistenceObject(UserEntity.class, id);
		return Optional.fromNullable(entity).transform(AccountEntityTrans.getUserEntity2UserFunc()).or(IUser.NONE);
	}

	@Override
	public List<IUser> getSellerByHid(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IUser addUser(IUser user) {
		Preconditions.checkNotNull(user);
		UserEntity entity = Optional.of(user).transform(AccountEntityTrans.getUser2UserEntityFunc()).get();
		userPersistence.insertPersistenceObjects(entity);
		return Optional.of(entity).transform(AccountEntityTrans.getUserEntity2UserFunc()).get();
	}

	@Override
	public IUser addSeller(IUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	public static AccountManager create() {
		// TODO Auto-generated method stub
		return manager;
	}

}
