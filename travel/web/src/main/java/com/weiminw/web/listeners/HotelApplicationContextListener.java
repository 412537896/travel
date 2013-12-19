package com.weiminw.web.listeners;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class ApplicatoinShutdownListener
 *
 */
public final class HotelApplicationContextListener implements ServletContextListener {
	private final static Logger logger = Logger.getLogger(HotelApplicationContextListener.class);
    private final static ExecutorService executors = Executors.newFixedThreadPool(10);
	/**
     * Default constructor. 
     */
    public HotelApplicationContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
        // TODO Auto-generated method stub
    	event.getServletContext().setAttribute("executors", executors);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event) {
    	event.getServletContext().setAttribute("executors", null);
    	this.executors.shutdown();//��ֹ�ύ�µ�����;
    	this.executors.shutdownNow();//ȡ�����ڵȴ������񣬲�������ֹ��������
    }
	
}
