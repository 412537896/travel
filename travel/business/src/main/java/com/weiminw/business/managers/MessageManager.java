package com.weiminw.business.managers;

import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.ITextMessage;
import com.weiminw.travel.interfaces.managers.ITextMessageManager;
import com.weiminw.travel.persistence.impls.MySqlPersistence;

public class MessageManager implements ITextMessageManager{
	final static MySqlPersistence<IHotel> persistence = MySqlPersistence.create();

	@Override
	public boolean insertMessage(ITextMessage message) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
