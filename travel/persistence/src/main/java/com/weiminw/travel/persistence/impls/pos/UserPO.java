package com.weiminw.travel.persistence.impls.pos;

import java.io.Serializable;

import javax.persistence.*;

import com.weiminw.travel.interfaces.IUser;

import java.util.Collection;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */

public class UserPO implements Serializable,IUser {
	private static final long serialVersionUID = 1L;
	private long id;
	private String fixLine;
	private String name;
	private String phone;
	private int type;

	public UserPO() {
	}


	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getFixLine() {
		return this.fixLine;
	}

	public void setFixLine(String fixLine) {
		this.fixLine = fixLine;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}


	@Override
	public String getCellPhone() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getCloudPushKey() {
		// TODO Auto-generated method stub
		return null;
	}



}