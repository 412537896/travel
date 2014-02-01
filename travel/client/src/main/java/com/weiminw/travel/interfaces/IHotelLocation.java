package com.weiminw.travel.interfaces;

public interface IHotelLocation {
	public long getId();
	public String getName();
	public double getLongitude();
	public double getLatitude();
	public static final IHotelLocation NONE = new Null();
	public static final class Null implements IHotelLocation {

		@Override
		public long getId() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public double getLongitude() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getLatitude() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}
