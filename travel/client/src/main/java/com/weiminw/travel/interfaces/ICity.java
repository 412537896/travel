package com.weiminw.travel.interfaces;

public interface ICity {
	
	static final ICity NULL = new Null();
	int getCityCode();
	String getCityName();
	static final class Null implements ICity{

		@Override
		public int getCityCode() {
			// TODO Auto-generated method stub
			return -1;
		}

		@Override
		public String getCityName() {
			// TODO Auto-generated method stub
			return "";
		}
		
	}
}
