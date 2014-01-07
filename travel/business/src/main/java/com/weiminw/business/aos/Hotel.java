package com.weiminw.business.aos;

import java.io.Serializable;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.persistence.impls.pos.HotelEntity;
import com.weiminw.travel.utils.LntLatCaculator;

public class Hotel implements IHotel,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5713403096635565244L;
	private final long id;
	private final String name;
	private final String address;
	private final double longitude;
	private final double latitude;
	private final String telephone;
	private final String description;
	private final int province;
	private final int city;
	
	public static final class Builder {
		private final long id;
		private String name;
		private String address;
		private double longitude;
		private double latitude;
		private String telephone;
		private String description;
		private int province;
		private int city;
		
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
		public Builder address(String address){
			this.address = address;
			return this;
		}
		public Builder longitude(double longitude){
			this.longitude = longitude;
			return this;
		}
		public Builder latitude(double latitude){
			this.latitude = latitude;
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
		public Builder province(int province){
			this.province = province;
			return this;
		}
		
		public Builder city(int city){
			this.city = city;
			return this;
		}
		
	}

	public static Builder builder(long id){
		return new Builder(id);
	}
	public static Builder builder(IHotel hotel){
		Builder builder = builder(hotel.getId());
		builder.address(hotel.getAddress())
			.city(hotel.getCity())
			.description(hotel.getDescription())
			.latitude(hotel.getLatitude())
			.longitude(hotel.getLongitude())
			.province(hotel.getProvince())
			.name(hotel.getName())
			.telephone(hotel.getTelephone());
		return builder;
	}
	
	private Hotel(Builder builder){
		this.id = builder.id;
		this.address = builder.address;
		this.latitude = builder.latitude;
		this.longitude = builder.longitude;
		this.name = builder.name;
		this.telephone = builder.telephone;
		this.description = builder.description;
		this.province = builder.province;
		this.city = builder.city;
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
	public String getAddress() {
		// TODO Auto-generated method stub
		return this.address;
	}

	@Override
	public double getLongitude() {
		// TODO Auto-generated method stub
		return this.longitude;
	}

	@Override
	public double getLatitude() {
		// TODO Auto-generated method stub
		return this.latitude;
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

	@Override
	public int getProvince() {
		// TODO Auto-generated method stub
		return this.province;
	}

	@Override
	public int getCity() {
		// TODO Auto-generated method stub
		return this.city;
	}
	
	public String toString(){
		return Objects.toStringHelper(this)
				.add("id",this.getId())
				.add("name", this.getName())
				.add("description", this.getDescription())
				.add("address", this.getAddress())
				.add("longitude", this.getLongitude())
				.add("latitude", this.getLatitude())
				.add("telephone", this.getTelephone())
				.add("city", this.getCity())
				.add("province", this.getProvince())
				.toString();
	}
	
	

}
