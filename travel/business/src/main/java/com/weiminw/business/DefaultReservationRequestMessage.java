package com.weiminw.business;

import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import com.weiminw.travel.interfaces.IReservationRequestMessage;
import com.weiminw.travel.interfaces.IUser;

public class DefaultReservationRequestMessage implements IReservationRequestMessage{
	private final static Logger logger = Logger.getLogger(DefaultReservationRequestMessage.class);
	private final static class ACallable implements Callable<String> {

		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			logger.debug("--------------");
			return null;
		}
		
	}
	private final ACallable callable ;
	private DefaultReservationRequestMessage(IUser from, IUser to) {
		// TODO Auto-generated constructor stub
		callable = new ACallable();
	}

	public static IReservationRequestMessage create(IUser from, IUser to) {
		// TODO Auto-generated method stub
		return new DefaultReservationRequestMessage(from,to);
	}

	@Override
	public void send() {
		// TODO Auto-generated method stub
		logger.debug("-----------");
		MessageSendWorker.execute(callable);
	}

}
