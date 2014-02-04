package com.weiminw.business.aos;

import com.google.common.base.Objects;
import com.weiminw.travel.interfaces.IUser;

public class User implements IUser {
	private final long id;
	private final String name ;
	private final String cellPhone;
	private final String fixTelephone;
	private final String cloudPushCk;
	private final String cloudPushUk;
	private final String cloudPushTag;
	
	public static final class Builder {
		private final long id;
		private String name = "";
		private String cellPhone = "";
		private String fixTelephone = "";
		private String cloudPushCk = "";
		private String cloudPushUk = "";
		private String cloudPushTag = "";
		public Builder(long id){
			this.id = id;
		}
		public IUser build() {
			// TODO Auto-generated method stub
			return new User(this);
		}
		public String getName() {
			return name;
		}
		public Builder setName(String name) {
			if(name!=null)
				this.name = name;
			return this;
		}
		public String getCellPhone() {
			return cellPhone;
		}
		public Builder setCellPhone(String cellPhone) {
			if(cellPhone != null)
				this.cellPhone = cellPhone;
			return this;
		}
		public String getFixTelephone() {
			return fixTelephone;
		}
		public Builder setFixTelephone(String fixTelephone) {
			if(fixTelephone != null)
				this.fixTelephone = fixTelephone;
			return this;
		}
		public String getCloudPushCk() {
			return cloudPushCk;
		}
		public Builder setCloudPushCk(String cloudPushCk) {
			if(cloudPushCk != null)
				this.cloudPushCk = cloudPushCk;
			return this;
		}
		public String getCloudPushUk() {
			return cloudPushUk;
		}
		public Builder setCloudPushUk(String cloudPushUk) {
			this.cloudPushUk = cloudPushUk;
			return this;
		}
		public String getCloudPushTag() {
			return cloudPushTag;
		}
		public Builder setCloudPushTag(String cloudPushTag) {
			this.cloudPushTag = cloudPushTag;
			return this;
		}
		public long getId() {
			return id;
		}
		
		
	}
	
	private User(Builder builder){
		this.id = builder.id;
		this.name = builder.name;
		this.fixTelephone = builder.fixTelephone;
		this.cellPhone = builder.cellPhone;
		this.cloudPushCk = builder.cloudPushCk;
		this.cloudPushUk = builder.cloudPushUk;
		this.cloudPushTag = builder.cloudPushTag;
	}
	
	public static Builder builder(){
		return new Builder(0L);
	}
	public static Builder builder(long id){
		return new Builder(id);
	}
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public String getCellPhone() {
		// TODO Auto-generated method stub
		return this.cellPhone;
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
	public String getFixTelephone() {
		// TODO Auto-generated method stub
		return this.fixTelephone;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	public String toString(){
		return Objects.toStringHelper(this).add("id", id)
		.add("name", name)
		.add("cellPhone", cellPhone)
		.add("fixTelephone", fixTelephone)
		.add("cloudPushCk", cloudPushCk)
		.add("cloudPushUk", cloudPushUk)
		.add("cloudPushTag", cloudPushTag)
		.toString();
	}

}
