package com.weiminw.business;

import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IMessage;
import com.weiminw.travel.interfaces.IMessageManager;
import com.weiminw.travel.persistence.impls.MySqlPersistence;

public class MessageManager implements IMessageManager{
	final static MySqlPersistence<IHotel> persistence = MySqlPersistence.create();
	@Override
	public boolean insertMessage(IMessage message) {
		// TODO Auto-generated method stub
		return false;
	}

}
