package com.weiminw.travel.interfaces;

import java.io.Serializable;

import com.google.common.base.Objects;

public interface IHotel extends Serializable {
	public long getId();

	public String getName();

	public String getAddress();

	public final static IHotel NULL = new Null();

	static final class Null implements IHotel {

		/**
		 * 
		 */
		private static final long serialVersionUID = -3773043675054478957L;

		private final long id = -1L;
		private final String name = "";
		private final String address = "";
		private final String description = "";
		private final String province = "";
		private final String city = "";
		private final double longtitude = -1D;
		private final double latitude = -1D;
		private final String telephone = "";

		public Null() {
			// TODO Auto-generated constructor stub
		}

		public long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getAddress() {
			return address;
		}

		public String getDescription() {
			return description;
		}

		public String getProvince() {
			return province;
		}

		public String getCity() {
			return city;
		}

		public double getLongtitude() {
			return longtitude;
		}

		public double getLatitude() {
			return latitude;
		}

		public String getTelephone() {
			return telephone;
		}

		public String toString() {
			return Objects.toStringHelper(this)
					.add("id", id)
					.add("name", name)
					.add("address", address)
					.add("description", description)
					.add("province", province)
					.add("longtitude", longtitude)
					.add("latitude", latitude)
					.add("telephone", telephone)
					.toString();

		};

	};
}
