package com.weiminw.business.aos;

import com.weiminw.travel.interfaces.IUser;

public class User implements IUser {
	

	private final long id;
	private final String name;
	private final String fixLine;
	private final String cellPhone;
	private final String cloudPushKey;
	
	public static final class Builder{
		private long id;
		private String name;
		private String fixLine;
		private String cellPhone;
		private String cloudPushKey;
		public Builder() {
		}
		public User build(){
			return new User(this);
		}
		public long getId() {
			return id;
		}
		public Builder setId(long id) {
			this.id = id;
			return this;
		}
		public String getName() {
			return name;
		}
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public String getFixLine() {
			return fixLine;
		}
		public Builder setFixLine(String fixLine) {
			this.fixLine = fixLine;
			return this;
		}
		public String getCellPhone() {
			return cellPhone;
		}
		public Builder setCellPhone(String cellPhone) {
			this.cellPhone = cellPhone;
			return this;
		}
		public String getCloudPushKey() {
			return cloudPushKey;
		}
		public Builder setCloudPushKey(String cloudPushKey) {
			this.cloudPushKey = cloudPushKey;
			return this;
		}
	}
	
	public User(Builder builder) {
		this.id = builder.id;
		this.cellPhone = builder.cellPhone;
		this.fixLine = builder.fixLine;
		this.name = builder.name;
		this.cloudPushKey = builder.cloudPushKey;
	}

	public static Builder builder() {
		// TODO Auto-generated method stub
		return new Builder();
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getFixLine() {
		// TODO Auto-generated method stub
		return this.fixLine;
	}

	@Override
	public String getCellPhone() {
		// TODO Auto-generated method stub
		return this.cellPhone;
	}

	@Override
	public String getCloudPushKey() {
		// TODO Auto-generated method stub
		return this.cloudPushKey;
	}
	
	
}
