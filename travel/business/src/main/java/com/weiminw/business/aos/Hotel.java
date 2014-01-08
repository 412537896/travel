package com.weiminw.business.aos;

import java.io.Serializable;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.weiminw.travel.interfaces.IAddress;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.ILocation;
import com.weiminw.travel.persistence.impls.pos.HotelEntity;
import com.weiminw.travel.utils.LntLatCaculator;

public class Hotel implements IHotel,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5713403096635565244L;
	private final long id;
	private final String name;
	private final String telephone;
	private final String description;
	private final IAddress address;
	private final ILocation location;

	
	public static final class Builder {
		private final long id;
		private String name;
		private String telephone;
		private String description;
		private IAddress address;
		private ILocation location;
		
		public IHotel build(){
			return new Hotel(this);
		}
		
		public Builder(long id){
			this.id = id;
		}
		public Builder name(String name){
			this.name = name;
			return this;
		}
		public Builder address(IAddress address){
			this.address = address;
			return this;
		}
		public Builder location(ILocation location){
			this.location = location;
			return this;
		}
		
		public Builder telephone(String telephone){
			this.telephone = telephone;
			return this;
		}
		public Builder description(String description){
			this.description = description;
			return this;
		}
		
	}

	public static Builder builder(long id){
		return new Builder(id);
	}
	public static Builder builder(IHotel hotel){
		Builder builder = builder(hotel.getId());
		builder.address(hotel.getAddress())
			.description(hotel.getDescription())
			.name(hotel.getName())
			.telephone(hotel.getTelephone())
			.location(hotel.getLocation());
		return builder;
	}
	
	private Hotel(Builder builder){
		this.id = builder.id;
		this.name = builder.name;
		this.telephone = builder.telephone;
		this.description = builder.description;
		this.address = builder.address;
		this.location = builder.location;
		
	}
	
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getTelephone() {
		// TODO Auto-generated method stub
		return this.telephone;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	
	public String toString(){
		return Objects.toStringHelper(this)
				.add("id",this.getId())
				.add("name", this.getName())
				.add("description", this.getDescription())
				.add("address", this.getAddress())
				.add("location", this.getLocation())
				.add("telephone", this.getTelephone())
				.toString();
	}
	@Override
	public IAddress getAddress() {
		// TODO Auto-generated method stub
		return this.address;
	}
	@Override
	public ILocation getLocation() {
		// TODO Auto-generated method stub
		return this.location;
	}
	
	

}
