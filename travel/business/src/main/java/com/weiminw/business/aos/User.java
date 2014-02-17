package com.weiminw.business.aos;

import com.google.common.base.Objects;
import com.weiminw.travel.interfaces.daos.IUser;

public class User implements IUser {
	private final long id;
	private final String name ;
	private final String cellPhone;
	private final String cloudPushCk;
	private final String cloudPushUk;
	private final String cloudPushTag;
	private final String password;
	private final String nick;
	
	private User(long id, String name, String cellPhone, String cloudPushCk,
			String cloudPushUk, String cloudPushTag, String password,
			String nick) {
		super();
		this.id = id;
		this.name = name;
		this.cellPhone = cellPhone;
		this.cloudPushCk = cloudPushCk;
		this.cloudPushUk = cloudPushUk;
		this.cloudPushTag = cloudPushTag;
		this.password = password;
		this.nick = nick;
	}
	
	public static IUser of(long id, String name, String cellPhone, String cloudPushCk,
			String cloudPushUk, String cloudPushTag, String password,
			String nick){
		return new User(id, name, cellPhone, cloudPushCk, cloudPushUk, cloudPushTag, password, nick);
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public String getCellPhone() {
		// TODO Auto-generated method stub
		return  this.cellPhone;
	}

	@Override
	public String getCloudPushCk() {
		// TODO Auto-generated method stub
		return this.cloudPushCk;
	}

	@Override
	public String getCloudPushTag() {
		// TODO Auto-generated method stub
		return this.cloudPushTag;
	}

	@Override
	public String getCloudPushUk() {
		// TODO Auto-generated method stub
		return this.cloudPushUk;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getNick() {
		// TODO Auto-generated method stub
		return this.nick;
	}

	@Override
	public IUser setId(long id) {
		// TODO Auto-generated method stub
		return new User(id, name, cellPhone, cloudPushCk, cloudPushUk, cloudPushTag, password, nick);
	}

	@Override
	public IUser setCellPhone(String cellPhone) {
		// TODO Auto-generated method stub
		return new User(id, name, cellPhone, cloudPushCk, cloudPushUk, cloudPushTag, password, nick);
	}

	@Override
	public IUser setCloudPushCk(String cloudPushCk) {
		// TODO Auto-generated method stub
		return new User(id, name, cellPhone, cloudPushCk, cloudPushUk, cloudPushTag, password, nick);
	}

	@Override
	public IUser setCloudPushTag(String cloudPushTag) {
		// TODO Auto-generated method stub
		return new User(id, name, cellPhone, cloudPushCk, cloudPushUk, cloudPushTag, password, nick);
	}

	@Override
	public IUser setCloudPushUk(String cloudPushUk) {
		// TODO Auto-generated method stub
		return new User(id, name, cellPhone, cloudPushCk, cloudPushUk, cloudPushTag, password, nick);
	}

	@Override
	public IUser setName(String name) {
		// TODO Auto-generated method stub
		return new User(id, name, cellPhone, cloudPushCk, cloudPushUk, cloudPushTag, password, nick);
	}

	@Override
	public IUser setPassword(String password) {
		// TODO Auto-generated method stub
		return new User(id, name, cellPhone, cloudPushCk, cloudPushUk, cloudPushTag, password, nick);
	}

	@Override
	public IUser setNick(String nick) {
		// TODO Auto-generated method stub
		return new User(id, name, cellPhone, cloudPushCk, cloudPushUk, cloudPushTag, password, nick);
	}
	
	
	
	
		
		
	

}
