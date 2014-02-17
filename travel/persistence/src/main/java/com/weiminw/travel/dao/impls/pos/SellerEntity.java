package com.weiminw.travel.dao.impls.pos;

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

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="cell_phone")
	private String cellPhone;

	@Column(name="cloud_push_ck")
	private String cloudPushCk;

	@Column(name="cloud_push_tag")
	private String cloudPushTag;

	@Column(name="cloud_push_uk")
	private String cloudPushUk;

	@Column(name="fix_telephone")
	private String fixTelephone;

	private int hid;

	private String identify;

	@Column(name="identify_type")
	private byte identifyType;

	private String name;

	private String password;

	public SellerEntity() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getCloudPushCk() {
		return this.cloudPushCk;
	}

	public void setCloudPushCk(String cloudPushCk) {
		this.cloudPushCk = cloudPushCk;
	}

	public String getCloudPushTag() {
		return this.cloudPushTag;
	}

	public void setCloudPushTag(String cloudPushTag) {
		this.cloudPushTag = cloudPushTag;
	}

	public String getCloudPushUk() {
		return this.cloudPushUk;
	}

	public void setCloudPushUk(String cloudPushUk) {
		this.cloudPushUk = cloudPushUk;
	}

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

	public String getIdentify() {
		return this.identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public byte getIdentifyType() {
		return this.identifyType;
	}

	public void setIdentifyType(byte identifyType) {
		this.identifyType = identifyType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}