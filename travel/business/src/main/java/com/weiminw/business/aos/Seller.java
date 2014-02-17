package com.weiminw.business.aos;

import java.io.Serializable;

import com.weiminw.travel.interfaces.daos.ISeller;
import com.weiminw.travel.interfaces.daos.IUser;

public class Seller implements ISeller,Serializable {
	

	private final long id;
	private final String cellPhone;
	private final String fixTelephone;
	private final String cloudPushCk;
	private final String cloudPushTag;
	private final String cloudPushUk;
	private final String name;
	private final String password;
	private final long hid;
	private final String identify;
	private final byte identifyType;
	private Seller(long id, String cellPhone, String fixTelephone,
			String cloudPushCk, String cloudPushTag, String cloudPushUk,
			String name, String password, long hid, String identify,
			byte identifyType) {
		super();
		this.id = id;
		this.cellPhone = cellPhone;
		this.fixTelephone = fixTelephone;
		this.cloudPushCk = cloudPushCk;
		this.cloudPushTag = cloudPushTag;
		this.cloudPushUk = cloudPushUk;
		this.name = name;
		this.password = password;
		this.hid = hid;
		this.identify = identify;
		this.identifyType = identifyType;
	}
	
	public static ISeller of(long id, String cellPhone, String fixTelephone,
			String cloudPushCk, String cloudPushTag, String cloudPushUk,
			String name, String password, long hid, String identify,
			byte identifyType){
		return new Seller(hid, cellPhone, fixTelephone, cloudPushCk, cloudPushTag, cloudPushUk, name, password, hid, identify, identifyType);
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public ISeller setId(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public String getCellPhone() {
		// TODO Auto-generated method stub
		return this.cellPhone;
	}

	@Override
	public ISeller setCellPhone(String cellPhone) {
		// TODO Auto-generated method stub
		return new Seller(hid, cellPhone, fixTelephone, cloudPushCk, cloudPushTag, cloudPushUk, name, password, hid, identify, identifyType);
	}

	@Override
	public String getCloudPushCk() {
		// TODO Auto-generated method stub
		return this.cloudPushCk;
	}

	@Override
	public ISeller setCloudPushCk(String cloudPushCk) {
		// TODO Auto-generated method stub
		return new Seller(hid, cellPhone, fixTelephone, cloudPushCk, cloudPushTag, cloudPushUk, name, password, hid, identify, identifyType);
	}

	@Override
	public String getCloudPushTag() {
		// TODO Auto-generated method stub
		return this.cloudPushTag;
	}

	@Override
	public ISeller setCloudPushTag(String cloudPushTag) {
		// TODO Auto-generated method stub
		return new Seller(hid, cellPhone, fixTelephone, cloudPushCk, cloudPushTag, cloudPushUk, name, password, hid, identify, identifyType);
	}

	@Override
	public String getCloudPushUk() {
		// TODO Auto-generated method stub
		return this.cloudPushUk;
	}

	@Override
	public ISeller setCloudPushUk(String cloudPushUk) {
		// TODO Auto-generated method stub
		return new Seller(hid, cellPhone, fixTelephone, cloudPushCk, cloudPushTag, cloudPushUk, name, password, hid, identify, identifyType);
	}

	@Override
	public String getFixTelephone() {
		// TODO Auto-generated method stub
		return this.fixTelephone;
	}

	@Override
	public ISeller setFixTelephone(String fixTelephone) {
		// TODO Auto-generated method stub
		return new Seller(hid, cellPhone, fixTelephone, cloudPushCk, cloudPushTag, cloudPushUk, name, password, hid, identify, identifyType);
	}

	@Override
	public long getHid() {
		// TODO Auto-generated method stub
		return this.hid;
	}

	@Override
	public ISeller setHid(int hid) {
		// TODO Auto-generated method stub
		return new Seller(hid, cellPhone, fixTelephone, cloudPushCk, cloudPushTag, cloudPushUk, name, password, hid, identify, identifyType);
	}

	@Override
	public String getIdentify() {
		// TODO Auto-generated method stub
		return this.identify;
	}

	@Override
	public ISeller setIdentify(String identify) {
		// TODO Auto-generated method stub
		return new Seller(hid, cellPhone, fixTelephone, cloudPushCk, cloudPushTag, cloudPushUk, name, password, hid, identify, identifyType);
	}

	@Override
	public byte getIdentifyType() {
		// TODO Auto-generated method stub
		return this.identifyType;
	}

	@Override
	public ISeller setIdentifyType(byte identifyType) {
		// TODO Auto-generated method stub
		return new Seller(hid, cellPhone, fixTelephone, cloudPushCk, cloudPushTag, cloudPushUk, name, password, hid, identify, identifyType);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISeller setName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISeller setPassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
}
