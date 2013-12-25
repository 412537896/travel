package com.weiminw.travel.interfaces;

import java.io.Serializable;
import java.util.Date;

public interface IReservationRequestMessage {
	public static final IReservationRequestMessage NULL = new Null();
	
	public final static class Null implements IReservationRequestMessage,Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 4471789341331743289L;
		private final String id = null;
		private final long senderId = -1L;
		private final long receiverId = -1L;
		private final double lowPrice = -1;
		private final double highPrice = -1;
		private final int roomNumber = -1;
		private final Date checkIn = null;
		private final Date checkOut = null;
		public String getId() {
			return id;
		}
		public double getLowPrice() {
			return lowPrice;
		}
		public double getHighPrice() {
			return highPrice;
		}
		public Date getCheckIn() {
			return checkIn;
		}
		public Date getCheckOut() {
			return checkOut;
		}
		public int getRoomNumber() {
			return roomNumber;
		}
		public long getSenderId() {
			return senderId;
		}
		public long getReceiverId() {
			return receiverId;
		}
		@Override
		public void send() {
			
		}
		
	}

	void send();
	
	
}
