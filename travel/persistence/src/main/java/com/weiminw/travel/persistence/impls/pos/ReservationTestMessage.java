package com.weiminw.travel.persistence.impls.pos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the text_request_message database table.
 * 
 */

public class ReservationTestMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Date checkIn;
	private Date checkOut;
	private double highPrice;
	private double lowPrice;
	private int roomNum;
	private int type;

	public ReservationTestMessage() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="check_in")
	public Date getCheckIn() {
		return this.checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="check_out")
	public Date getCheckOut() {
		return this.checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}


	@Column(name="high_price")
	public double getHighPrice() {
		return this.highPrice;
	}

	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}


	@Column(name="low_price")
	public double getLowPrice() {
		return this.lowPrice;
	}

	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}


	@Column(name="room_num")
	public int getRoomNum() {
		return this.roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}


	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

}