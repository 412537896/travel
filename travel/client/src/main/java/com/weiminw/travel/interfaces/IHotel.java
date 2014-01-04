package com.weiminw.travel.interfaces;

import java.io.Serializable;

import com.google.common.base.Objects;

public interface IHotel extends Serializable {
	public long getId();
	public String getName();
	public String getAddress();
	public double getLongitude();
	public double getLatitude();
	public String getTelephone();
	public String getDescription();
	public int getProvince();
	public int getCity();
	public final static IHotel NULL = new Null();

	static final class Null implements IHotel {

		/**
		 * 
		 */
		private static final long serialVersionUID = -3773043675054478957L;
		public Null() {
			// TODO Auto-generated constructor stub
		}

		public long getId() {
			return -1L;
		}

		public String getName() {
			return "";
		}

		public String getAddress() {
			return "";
		}

		public double getLongtitude() {
			return -1D;
		}

		public double getLatitude() {
			return -1D;
		}

		public String getTelephone() {
			return "";
		}
		
		@Override
		public double getLongitude() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "";
		}
		public String toString(){
			return Objects.toStringHelper(this).toString();
		}

		@Override
		public int getProvince() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getCity() {
			// TODO Auto-generated method stub
			return 0;
		}
		

	};
}
