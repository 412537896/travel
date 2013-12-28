package com.weiminw.business.workers;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;


public final class MessageSendWorker {
	private static final ExecutorService executor = Executors.newFixedThreadPool(100);
	private static final Logger logger = Logger.getLogger(MessageSendWorker.class);
	public static void execute(Callable<String> callable) {
		// TODO Auto-generated method stub
		executor.submit(callable);
	}

}
