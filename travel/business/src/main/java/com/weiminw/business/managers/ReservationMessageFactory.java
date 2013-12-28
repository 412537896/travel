package com.weiminw.business.managers;

import com.weiminw.travel.interfaces.IReservationRequestMessage;
import com.weiminw.travel.interfaces.IUser;

public final class ReservationMessageFactory {

	public static IReservationRequestMessage createRequestMessage(IUser from, IUser to) {
		return DefaultReservationRequestMessage.create(from,to);
		
	}

}
