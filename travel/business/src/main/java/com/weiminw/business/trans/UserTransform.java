package com.weiminw.business.trans;

import com.google.common.base.Function;
import com.weiminw.business.aos.Seller;
import com.weiminw.business.aos.User;
import com.weiminw.travel.interfaces.IUser;
import com.weiminw.travel.persistence.impls.pos.SellerEntity;
import com.weiminw.travel.persistence.impls.pos.UserEntity;

public final class UserTransform {
	public static Function<SellerEntity,IUser> SellerEntity2Seller(){
		return new Function<SellerEntity,IUser>(){

			@Override
			public Seller apply(SellerEntity input) {
				Seller seller = Seller.builder(input.getId())
					.setCellPhone(input.getCellPhone())
					.setCloudPushCk(input.getCloudPushCk())
					.setCloudPushTag(input.getCloudPushTag())
					.setCloudPushUk(input.getCloudPushUk())
					.setFixTelephone(input.getFixTelephone())
					.setName(input.getName()).build();
				return seller;
			}
		};
	}

	public static Function<Seller, SellerEntity> Seller2SellerEntity() {
		// TODO Auto-generated method stub
		return new Function<Seller, SellerEntity>(){

			@Override
			public SellerEntity apply(Seller input) {
				SellerEntity entity = new SellerEntity();
				entity.setCellPhone(input.getCellPhone()); 
				entity.setCloudPushCk(input.getCloudPushCk());
				entity.setCloudPushTag(input.getCloudPushTag());
				entity.setCloudPushUk(input.getCloudPushUk());
				entity.setFixTelephone(input.getFixTelephone());
				entity.setName(input.getName());
				entity.setCellPhone(input.getCellPhone()); 
				return entity;
			}
			
		};
	}

	public static Function<User, UserEntity> User2UserEntity() {
		// TODO Auto-generated method stub
		return new Function<User, UserEntity>(){

			@Override
			public UserEntity apply(User input) {
				UserEntity entity = new UserEntity();
				entity.setCellPhone(input.getCellPhone()); 
				entity.setCloudPushCk(input.getCloudPushCk());
				entity.setCloudPushTag(input.getCloudPushTag());
				entity.setCloudPushUk(input.getCloudPushUk());
				entity.setFixTelephone(input.getFixTelephone());
				entity.setName(input.getName());
				entity.setCellPhone(input.getCellPhone()); 
				return entity;
			}
			
		};
	}
}
