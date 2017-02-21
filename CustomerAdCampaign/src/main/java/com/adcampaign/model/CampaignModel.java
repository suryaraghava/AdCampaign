package com.adcampaign.model;

import java.io.Serializable;

public class CampaignModel implements Serializable{

	private int id;
	private String name;
	private String partner_id;
	private String duration;
	private String ad_content;
	private String active;
	
	
	public CampaignModel(int id, String name, String partner_id, String duration, String ad_content, String active) {
		this.id = id;
		this.name = name;
		this.partner_id = partner_id;
		this.duration = duration;
		this.ad_content = ad_content;
		this.active = active;
	}
	public CampaignModel() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String isActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getAd_content() {
		return ad_content;
	}
	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}
	
	@Override
	public String toString() {
		return "CampaignModel [partner_id=" + partner_id + ", duration=" + duration + ", ad_content=" + ad_content
				+ "]";
	}
	
}
