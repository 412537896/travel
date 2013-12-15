package com.weiminw.travel.interfaces;

public interface IProvince {
	static final IProvince NULL = new Null();
	int getProvinceCode();
	String getProvinceName();
	static final class Null implements IProvince {

		@Override
		public int getProvinceCode() {
			// TODO Auto-generated method stub
			return -1;
		}

		@Override
		public String getProvinceName() {
			// TODO Auto-generated method stub
			return "";
		}
		
	}
}
