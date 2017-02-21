package com.adcampaign.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adcampaign.dao.ICampaignDAO;
import com.adcampaign.model.CampaignModel;

@Controller
public class CampaignController {

	private static final Logger logger = LoggerFactory.getLogger(CampaignController.class);

	@Autowired
	ICampaignDAO dao;
	
	@RequestMapping(value="/postCampaign", method = RequestMethod.POST, consumes = "application/json", produces="application/json")
	public void  postCampaign(@RequestBody String model) throws JsonParseException, JsonMappingException, IOException{
		 ObjectMapper objectMapper = new ObjectMapper(); 
		 CampaignModel campaign = objectMapper. readValue(model, CampaignModel.class);
		 dao.createCampaign(campaign);
		//return new ResponseEntity(campaign,HttpStatus.OK);
	}

	@RequestMapping(value="/getAllCampaigns", method = RequestMethod.GET )
	public @ResponseBody String getAllCampaigns() throws JsonGenerationException, JsonMappingException, IOException{
		List<CampaignModel> campaignModel = dao.getCampaigns();
		ObjectMapper objectMapper = new ObjectMapper(); 
		String result = objectMapper.writeValueAsString(campaignModel);
		return result;
	}
	
	@RequestMapping(value="/getCampaigns/{id}", method = RequestMethod.GET )
	public @ResponseBody String getCampaignsByID(@PathVariable int id) throws JsonGenerationException, JsonMappingException, IOException{
		List<CampaignModel> campaignModel = dao.getCampaignByID(id);
		ObjectMapper objectMapper = new ObjectMapper(); 
		String result = objectMapper.writeValueAsString(campaignModel);
		return result;
	}
	
	@RequestMapping(value="/getActiveCampaign/{partnerid}", method = RequestMethod.GET )
	public @ResponseBody String getActiveCampaign(@PathVariable int partnerid) throws JsonGenerationException, JsonMappingException, IOException{
		List<CampaignModel> campaignModel = dao.getCampaignByPartnerID(partnerid);
		ObjectMapper objectMapper = new ObjectMapper(); 
		String result = objectMapper.writeValueAsString(campaignModel);
		return result;
	}
	
	@RequestMapping(value="/deleteCampaign/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteCampaign(@PathVariable int id){
		dao.deleteCampaign(id);
		return "";
	}
	
	@RequestMapping(value="/updateCampaign/{id}", method = RequestMethod.PUT)
	public @ResponseBody String updateCampaign(@RequestBody String model) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper objectMapper = new ObjectMapper(); 
		CampaignModel campaign = objectMapper. readValue(model, CampaignModel.class);
		dao.updateCampaign(campaign);
		return "";
	}
	
}