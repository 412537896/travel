package com.weiminw.travel.persistence.impls.pos;


import javax.persistence.*;

import com.weiminw.travel.interfaces.IRoomType;

/**
 * Entity implementation class for Entity: RoomTypePO
 *
 */
@Entity(name="room_type")
@NamedQuery(name="RoomType.findByHid",query="select R from room_type R where R.hid =:hid")
public final class RoomTypePO implements IRoomType {

	
	private static final long serialVersionUID = 1L;
	private long id ;
	private long hid ;
	private String name ;
	private String bedType ;
	private String description ;
	public RoomTypePO() {
		// TODO Auto-generated constructor stub
	}
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="hid")
	public long getHid() {
		return hid;
	}
	public void setHid(long hid) {
		this.hid = hid;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="bed_type")
	public String getBedType() {
		return bedType;
	}
	public void setBedType(String bedType) {
		this.bedType = bedType;
	}
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
   
}
