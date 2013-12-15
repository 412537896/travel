package com.weiminw.travel.persistence.impls.pos;

import java.io.Serializable;

import javax.persistence.*;

import com.weiminw.travel.interfaces.IRoomType;

import java.math.BigInteger;


/**
 * The persistent class for the room_type database table.
 * 
 */
@Entity
@Table(name="room_type")
@NamedQuery(name="RoomType.findAllByHid", query="SELECT r FROM RoomType r where hid=:hid")
public class RoomTypePO implements Serializable,IRoomType {
	private static final long serialVersionUID = 1L;
	private long id;
	private String bedType;
	private long hid;
	private String name;

	public RoomTypePO() {
	}


	@Id
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}


	@Column(name="bed_type")
	public String getBedType() {
		return this.bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}




	public long getHid() {
		return this.hid;
	}

	public void setHid(long hid) {
		this.hid = hid;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}