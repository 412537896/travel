package com.weiminw.travel.persistence.impls.pos;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the geo_code_name_map database table.
 * 
 */
@Entity
@Table(name="geo_code_name_map")
@NamedQueries(value = { 
		
		@NamedQuery(name="GeoEntity.findAll", query="SELECT g FROM GeoEntity g"),
		@NamedQuery(name="HotelEntity.findProvince", query="SELECT g FROM GeoEntity g where g.provinceCode = :provinceCode group by g.provinceCode ")		
		
})

public class GeoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String cityAbbName;
	private int cityCode;
	private String cityName;
	private String districtAbbName;
	private int districtCode;
	private String districtName;
	private int provinceCode;
	private String provinceName;

	public GeoEntity() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(name="city_abb_name")
	public String getCityAbbName() {
		return this.cityAbbName;
	}

	public void setCityAbbName(String cityAbbName) {
		this.cityAbbName = cityAbbName;
	}


	@Column(name="city_code")
	public int getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}


	@Column(name="city_name")
	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	@Column(name="district_abb_name")
	public String getDistrictAbbName() {
		return this.districtAbbName;
	}

	public void setDistrictAbbName(String districtAbbName) {
		this.districtAbbName = districtAbbName;
	}


	@Column(name="district_code")
	public int getDistrictCode() {
		return this.districtCode;
	}

	public void setDistrictCode(int districtCode) {
		this.districtCode = districtCode;
	}


	@Column(name="district_name")
	public String getDistrictName() {
		return this.districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}


	@Column(name="province_code")
	public int getProvinceCode() {
		return this.provinceCode;
	}

	public void setProvinceCode(int provinceCode) {
		this.provinceCode = provinceCode;
	}


	@Column(name="province_name")
	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}