package com.weiminw.travel.interfaces;

import java.io.Serializable;

import com.google.common.base.Objects;

public interface IHotel extends Serializable {
	public long getId();
	public String getName();
	public String getTelephone();
	public String getDescription();
	public IAddress getAddress();
	public ILocation getLocation();
	
	public final static IHotel NULL = new Null();

	static final class Null implements IHotel {

		/**
		 * 
		 */
		private static final long serialVersionUID = -3773043675054478957L;
		public Null() {
			// TODO Auto-generated constructor stub
		}
		@Override
		public long getId() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getTelephone() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public IAddress getAddress() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ILocation getLocation() {
			// TODO Auto-generated method stub
			return null;
		}

		
		

	};
}
