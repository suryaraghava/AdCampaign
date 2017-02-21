package com.adcampaign.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.adcampaign.model.CampaignModel;

@Repository
public class CampaignDAOImpl implements ICampaignDAO{
	
NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void createCampaign(CampaignModel campaignModel) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", campaignModel.getName());
		map.put("partner_id", ""+campaignModel.getPartner_id());
		map.put("duration", ""+campaignModel.getDuration());
		map.put("ad_content", campaignModel.getAd_content());
		map.put("active", ""+campaignModel.isActive());
		String sqlCreateStatement = "insert into campaign(name,partner_id,duration,ad_content,active) values(:name,:partner_id,:duration,:ad_content,:active)";
		namedParameterJdbcTemplate.update(sqlCreateStatement, map);
	}

	@Override
	public List<CampaignModel> getCampaigns() {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "SELECT * FROM campaign";
        List<CampaignModel> result = namedParameterJdbcTemplate.query(sql, params, new CampaignMapper());
        return result;
	}

	@Override
	public List<CampaignModel> getCampaignByID(int id) {
		// TODO Auto-generated method stub
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("id", id);
				String sql = "SELECT * FROM campaign where id=:id";
		        List<CampaignModel> result = namedParameterJdbcTemplate.query(sql, params, new CampaignMapper());
		        return result;
	}

	@Override
	public void deleteCampaign(int id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		String sql = "delete FROM campaign where id=:id";
		namedParameterJdbcTemplate.update(sql, params);
		
	}
	
	@Override
	public void updateCampaign(CampaignModel campaignModel) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", campaignModel.getName());
		map.put("partner_id", ""+campaignModel.getPartner_id());
		map.put("duration", ""+campaignModel.getDuration());
		map.put("ad_content", campaignModel.getAd_content());
		map.put("active", ""+campaignModel.isActive());
		String sqlCreateStatement = "update table campaign(name,partner_id,duration,ad_content,active) values(:name,:partner_id,:duration,:ad_content,:active)";
		
	}
	
	private static final class CampaignMapper implements RowMapper<CampaignModel> {

		public CampaignModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			CampaignModel campaign = new CampaignModel();
			campaign.setId(rs.getInt("id"));
			campaign.setName(rs.getString("name"));
			campaign.setActive(rs.getString("active"));
			campaign.setAd_content(rs.getString("ad_content"));
			campaign.setDuration(rs.getString("duration"));
			campaign.setPartner_id(rs.getString("partner_id"));
			return campaign;
		}
	}

	@Override
	public List<CampaignModel> getCampaignByPartnerID(int id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		String sql = "SELECT * FROM campaign where partner_id=:id";
        List<CampaignModel> result = namedParameterJdbcTemplate.query(sql, params, new CampaignMapper());
        return result;
	}

	

}
