package com.weiminw.travel.interfaces;


public interface IUser {
	public static final IUser NULL = new Null();

	public static final class Null implements IUser {

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
		public String getFixLine() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getCellPhone() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getCloudPushKey() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public long getId() ;
	public String getName() ;
	public String getFixLine();
	public String getCellPhone();
	public String getCloudPushKey() ;
}
