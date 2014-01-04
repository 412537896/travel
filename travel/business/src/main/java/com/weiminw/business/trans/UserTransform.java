package com.weiminw.business.trans;

import com.google.common.base.Function;
import com.weiminw.travel.interfaces.IUser;
import com.weiminw.travel.persistence.impls.pos.UserPO;

public final class UserTransform {
	public static Function<IUser,UserPO> User2UserEntity(){
		return new Function<IUser,UserPO>(){

			@Override
			public UserPO apply(IUser input) {
				UserPO po = new UserPO();
				po.setFixLine(input.getFixLine());
				po.setId(input.getId());
				po.setName(input.getName());
				po.setPhone(input.getCellPhone());
				return po;
			}
		};
	}
}
