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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adcampaign.dao.IPartnerDAO;
import com.adcampaign.model.PartnerModel;

@Controller
public class PartnerController {

	private static final Logger logger = LoggerFactory.getLogger(PartnerController.class);

	@Autowired
	IPartnerDAO dao;
	
	@RequestMapping(value="/postPartner", method = RequestMethod.POST, consumes = "application/json", produces="application/json")
	public void  postPartner(@RequestBody String model) throws JsonParseException, JsonMappingException, IOException{
		 ObjectMapper objectMapper = new ObjectMapper(); 
		 PartnerModel Partner = objectMapper. readValue(model, PartnerModel.class);
		 dao.createPartner(Partner);
		//return new ResponseEntity(Partner,HttpStatus.OK);
	}

	@RequestMapping(value="/getAllPartners", method = RequestMethod.GET )
	public @ResponseBody String getAllPartners() throws JsonGenerationException, JsonMappingException, IOException{
		List<PartnerModel> PartnerModel = dao.getPartners();
		ObjectMapper objectMapper = new ObjectMapper(); 
		String result = objectMapper.writeValueAsString(PartnerModel);
		return result;
	}
	
	@RequestMapping(value="/getPartners/{id}", method = RequestMethod.GET )
	public @ResponseBody String getPartnersByID(@PathVariable int id) throws JsonGenerationException, JsonMappingException, IOException{
		List<PartnerModel> PartnerModel = dao.getPartnerID(id);
		ObjectMapper objectMapper = new ObjectMapper(); 
		String result = objectMapper.writeValueAsString(PartnerModel);
		return result;
	}
	
	@RequestMapping(value="/deletePartner/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deletePartner(@PathVariable int id){
		dao.deletePartner(id);
		return "";
	}
	
	@RequestMapping(value="/updatePartner/{id}", method = RequestMethod.PUT)
	public @ResponseBody String updatePartner(@RequestBody String model) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper objectMapper = new ObjectMapper(); 
		PartnerModel Partner = objectMapper. readValue(model, PartnerModel.class);
		dao.updatePartner(Partner);
		return "";
	}
	
}
