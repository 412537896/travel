package com.weiminw.travel.dao.impls.pos;

import java.io.Serializable;

import javax.persistence.*;

import com.weiminw.travel.interfaces.daos.IRoomType;

import java.math.BigInteger;


/**
 * The persistent class for the room_type database table.
 * 
 */
@Entity
@Table(name="room_type")
@NamedQuery(name="RoomTypeEntity.findAll", query="SELECT r FROM RoomTypeEntity r")
public class RoomTypeEntity implements Serializable,IRoomType {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="bed_type")
	private String bedType;

	private long hid;

	private String name;


	public RoomTypeEntity() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBedType() {
		return this.bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
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

	@Override
	public long getHid() {
		// TODO Auto-generated method stub
		return this.hid;
	}

}