package com.adcampaign.dao;

import java.util.List;

import com.adcampaign.model.PartnerModel;

public interface IPartnerDAO {

	public void createPartner(PartnerModel partnerModel);
	public List<PartnerModel> getPartners();
	public List<PartnerModel> getPartnerID(int id);
	public void deletePartner(int id);
	public void updatePartner(PartnerModel partnerModel);
	
}
