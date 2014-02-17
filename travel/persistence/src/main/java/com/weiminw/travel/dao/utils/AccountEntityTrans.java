package com.weiminw.travel.dao.utils;

import com.google.common.base.Function;
import com.weiminw.business.aos.User;
import com.weiminw.travel.dao.impls.pos.UserEntity;
import com.weiminw.travel.interfaces.daos.IUser;

public final class AccountEntityTrans {
	private static final class UserEntity2User implements Function<UserEntity,IUser> {

		@Override
		public IUser apply(UserEntity input) {
			// TODO Auto-generated method stub
			return User.of(input.getId(), input.getName(), input.getCellPhone(), input.getCloudPushCk(), input.getCloudPushUk(), input.getCloudPushTag(), input.getPassword(), input.getNick());
		}
		
	}
	
	private static final class User2UserEntity implements Function<IUser,UserEntity>{

		@Override
		public UserEntity apply(IUser input) {
			return UserEntity.of(input);
		}
		
	}
	
	private static final Function<UserEntity,IUser> _UserEntity2User = new UserEntity2User();
	private static final Function<IUser,UserEntity> _User2UserEntity = new User2UserEntity();
	
	public static Function<UserEntity,IUser> getUserEntity2UserFunc(){
		return _UserEntity2User; 
	}
	
	public static Function<IUser,UserEntity> getUser2UserEntityFunc(){
		return _User2UserEntity;
	}
}
