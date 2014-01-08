package com.weiminw.business.aos;

import com.weiminw.travel.interfaces.IAddress;

public class Address implements IAddress { 
	private final int provinceCode;
	private final int cityCode;
	private final String province;
	private final String city;
	private final String detail;
	
	private Address(int provinceCode,String province,int cityCode,String city,String detail) {
		this.provinceCode = provinceCode;
		this.province = province;
		this.cityCode = cityCode;
		this.city = city;
		this.detail = detail;
	}
	public static Address of(int proviceCode,String province,int cityCode,String city,String detail){
		return new Address(proviceCode, province, cityCode, city, detail);
	}
	@Override
	public String getProvince() {
		// TODO Auto-generated method stub
		return this.province;
	}

	@Override
	public String getCity() {
		// TODO Auto-generated method stub
		return this.city;
	}

	@Override
	public String getDetail() {
		// TODO Auto-generated method stub
		return this.detail;
	}
	public int getProvinceCode() {
		return provinceCode;
	}
	public int getCityCode() {
		return cityCode;
	}

}
