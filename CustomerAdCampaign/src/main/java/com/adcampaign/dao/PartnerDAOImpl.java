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
import com.adcampaign.model.PartnerModel;

@Repository
public class PartnerDAOImpl implements IPartnerDAO{

	
NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	@Override
	public void createPartner(PartnerModel partnerModel) {
		// TODO Auto-generated method stub
				Map<String,String> map = new HashMap<String,String>();
				map.put("name", partnerModel.getName());
				map.put("partner_id", ""+partnerModel.getId());
				map.put("duration", ""+partnerModel.getEmail());
				String sqlCreateStatement = "insert into partner(name,email) values(:name,:email)";
				namedParameterJdbcTemplate.update(sqlCreateStatement, map);
		
	}

	@Override
	public List<PartnerModel> getPartners() {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "SELECT * FROM partner";
        List<PartnerModel> result = namedParameterJdbcTemplate.query(sql, params, new PartnerMapper());
        return result;
	}

	@Override
	public List<PartnerModel> getPartnerID(int id) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		String sql = "SELECT * FROM partner where id=:id";
        List<PartnerModel> result = namedParameterJdbcTemplate.query(sql, params, new PartnerMapper());
        return result;
	}

	@Override
	public void deletePartner(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("id", id);
				String sql = "delete FROM partner where id=:id";
		        namedParameterJdbcTemplate.update(sql, params);
	}

	@Override
	public void updatePartner(PartnerModel partnerModel) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", partnerModel.getName());
		map.put("partner_id", ""+partnerModel.getId());
		map.put("duration", ""+partnerModel.getEmail());
		String sqlCreateStatement = "update table partner(name,email) values(:name,:email)";
		
	}
	
	private static final class PartnerMapper implements RowMapper<PartnerModel> {

		public PartnerModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			PartnerModel partner = new PartnerModel();
			partner.setId(rs.getInt("id"));
			partner.setName(rs.getString("name"));
			partner.setEmail(rs.getString("email"));
			return partner;
		}
	}
	
}
