package com.adcampaign.dao;

import java.util.List;

import com.adcampaign.model.CampaignModel;

public interface ICampaignDAO {
	
	public void createCampaign(CampaignModel campaignModel);
	public List<CampaignModel> getCampaigns();
	public List<CampaignModel> getCampaignByID(int id);
	public List<CampaignModel> getCampaignByPartnerID(int id);
	public void deleteCampaign(int id);
	public void updateCampaign(CampaignModel campaignModel);
}
