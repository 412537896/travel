package com.weiminw.business.aos;

import com.weiminw.travel.interfaces.ICity;

public class City implements ICity {

	public static final class Builder {
		private int cityCode = 0;
		private String cityName = "";
		public Builder() {
			// TODO Auto-generated constructor stub
		}
		public City build(){
			return new City(this);
		}
		public int getCityCode() {
			return cityCode;
		}
		public Builder setCityCode(int cityCode) {
			if(cityCode >0 )
				this.cityCode = cityCode;
			return this;
		}
		public String getCityName() {
			return cityName;
		}
		public Builder setCityName(String cityName) {
			if(cityName != null)
				this.cityName = cityName;
			return this;
		}
	}

	private final int cityCode;
	private final String cityName;
	
	
	public City(Builder builder) {
		// TODO Auto-generated constructor stub
		this.cityCode = builder.cityCode;
		this.cityName = builder.cityName;
	}
	public static Builder builder(){
		return new Builder();
	}

	@Override
	public int getCityCode() {
		// TODO Auto-generated method stub
		return this.cityCode;
	}

	@Override
	public String getCityName() {
		// TODO Auto-generated method stub
		return this.cityName;
	}

}
