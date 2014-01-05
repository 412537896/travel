package com.weiminw.travel.interfaces;


public interface IUser {
	public static final IUser NONE = new Null();

	public static final class Null implements IUser {

		@Override
		public long getId() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String getCellPhone() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getCloudPushCk() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getCloudPushTag() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getCloudPushUk() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getFixTelephone() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		
		
	}
	
	public long getId() ;

	public String getCellPhone();

	public String getCloudPushCk();

	public String getCloudPushTag();

	public String getCloudPushUk() ;

	public String getFixTelephone() ;

	public String getName() ;
}
