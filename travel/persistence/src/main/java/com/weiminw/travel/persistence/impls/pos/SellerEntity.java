package com.weiminw.travel.persistence.impls.pos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seller database table.
 * 
 */
@Entity
@Table(name="seller")
@NamedQueries(value = { 
		@NamedQuery(name="SellerEntity.findAll", query="SELECT u FROM SellerEntity u"),
		@NamedQuery(name="SellerEntity.findAllByHid", query="SELECT u FROM SellerEntity u where u.hid = :hid"),
})
public class SellerEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String cellPhone;
	private String cloudPushCk;
	private String cloudPushTag;
	private String cloudPushUk;
	private String fixTelephone;
	private int hid;
	private String name;

	public SellerEntity() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(name="cell_phone")
	public String getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}


	@Column(name="cloud_push_ck")
	public String getCloudPushCk() {
		return this.cloudPushCk;
	}

	public void setCloudPushCk(String cloudPushCk) {
		this.cloudPushCk = cloudPushCk;
	}


	@Column(name="cloud_push_tag")
	public String getCloudPushTag() {
		return this.cloudPushTag;
	}

	public void setCloudPushTag(String cloudPushTag) {
		this.cloudPushTag = cloudPushTag;
	}


	@Column(name="cloud_push_uk")
	public String getCloudPushUk() {
		return this.cloudPushUk;
	}

	public void setCloudPushUk(String cloudPushUk) {
		this.cloudPushUk = cloudPushUk;
	}


	@Column(name="fix_telephone")
	public String getFixTelephone() {
		return this.fixTelephone;
	}

	public void setFixTelephone(String fixTelephone) {
		this.fixTelephone = fixTelephone;
	}


	public int getHid() {
		return this.hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}