package com.weiminw.business.aos;

import com.weiminw.travel.interfaces.IUser;

public class Seller implements IUser {
	

	private final long id;
	private final String cellPhone;
	private final String cloudPushCk;
	private final String cloudPushTag;
	private final String cloudPushUk;
	private final String fixTelephone;
	private final String name;
	
	public static final class Builder{
		private final long id;
		private String cellPhone;
		private String cloudPushCk;
		private String cloudPushTag;
		private String cloudPushUk;
		private String fixTelephone;
		private String name;
		public Builder(long id) {
			this.id = id;
		}
		public Seller build(){
			return new Seller(this);
		}
		public long getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public String getCellPhone() {
			return cellPhone;
		}
		public Builder setCellPhone(String cellPhone) {
			this.cellPhone = cellPhone;
			return this;
		}
		public String getCloudPushCk() {
			return cloudPushCk;
		}
		public Builder setCloudPushCk(String cloudPushCk) {
			this.cloudPushCk = cloudPushCk;
			return this;
		}
		public String getCloudPushTag() {
			return cloudPushTag;
		}
		public Builder setCloudPushTag(String cloudPushTag) {
			this.cloudPushTag = cloudPushTag;
			return this;
		}
		public String getCloudPushUk() {
			return cloudPushUk;
		}
		public Builder setCloudPushUk(String cloudPushUk) {
			this.cloudPushUk = cloudPushUk;
			return this;
		}
		public String getFixTelephone() {
			return fixTelephone;
		}
		public Builder setFixTelephone(String fixTelephone) {
			this.fixTelephone = fixTelephone;
			return this;
		}
		
	}
	
	public Seller(Builder builder) {
		this.id = builder.id;
		this.cellPhone = builder.cellPhone;
		this.cloudPushCk = builder.cloudPushCk;
		this.cloudPushTag = builder.cloudPushTag;
		this.cloudPushUk = builder.cloudPushUk;
		this.fixTelephone = builder.fixTelephone;
		this.name = builder.name;
	}

	public static Builder builder(long id) {
		// TODO Auto-generated method stub
		return new Builder(id);
	}
	public static Builder builder() {
		// TODO Auto-generated method stub
		return new Builder(0);
	}
	
	

	public long getId() {
		return id;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public String getCloudPushCk() {
		return cloudPushCk;
	}

	public String getCloudPushTag() {
		return cloudPushTag;
	}

	public String getCloudPushUk() {
		return cloudPushUk;
	}

	public String getFixTelephone() {
		return fixTelephone;
	}

	public String getName() {
		return name;
	}

	
	
	
}
