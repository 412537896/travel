package com.weiminw.business;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.weiminw.travel.interfaces.IReservationRequest;
import com.weiminw.travel.interfaces.ISeller;

public class MessageSender {
	private static final ExecutorService s = Executors.newFixedThreadPool(100);
	private static final Logger logger = Logger.getLogger(MessageSender.class);
	public static void sendMessage(IReservationRequest request, ISeller seller) {
		// TODO Auto-generated method stub
		s.submit(new Callable<String>(){

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				System.out.println("00000");
				return "";
			}});
	}

}
