package com.weiminw.business.aos;

import com.weiminw.travel.interfaces.IProvince;

public class Province implements IProvince {
	
	public static final class Builder {
		private int provinceCode = 0;
		private String provinceName= "";
		
		public Builder() {
			// TODO Auto-generated constructor stub
		}
		public Province build(){
			return new Province(this);
		}
		public int getProvinceCode() {
			return provinceCode;
		}

		public Builder setProvinceCode(int provinceCode) {
			if(provinceCode >0)
				this.provinceCode = provinceCode;
			return this;
		}

		public String getProvinceName() {
			
			return provinceName;
		}

		public Builder setProvinceName(String provinceName) {
			if(provinceName != null)
				this.provinceName = provinceName;
			return this;
		}
	}

	
	private final int provinceCode;
	private final String provinceName;
	
	public Province(Builder builder) {
		// TODO Auto-generated constructor stub
		this.provinceCode = builder.provinceCode;
		this.provinceName = builder.provinceName;
	}
	public static Builder builder(){
		return new Builder();
	}

	@Override
	public int getProvinceCode() {
		// TODO Auto-generated method stub
		return provinceCode;
	}

	@Override
	public String getProvinceName() {
		// TODO Auto-generated method stub
		return provinceName;
	}

}
