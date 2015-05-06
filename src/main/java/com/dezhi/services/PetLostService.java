package com.dezhi.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import com.dezhi.entity.PetLostEntity;

public class PetLostService implements IPetLostService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<PetLostEntity> queryPetLostInfo(int page, String location) {
		// TODO Auto-generated method stub

		// List view 下拉每次显示3个
		String sql = "select * from tbl_petLost where 1=1 ";

		if (!StringUtils.isEmpty(location)) {
			sql += " and location = '" + location + "'";
		}
		
		sql+=" order by id desc ";

		if (page == 0) {
			sql += " limit 0,10";
		} else {

			int s = ((page - 1) * 3) + 10;

			sql += " limit " + s + ",3";

		}
		
		

		return jdbcTemplate.query(sql, new RowMapper<PetLostEntity>() {

			public PetLostEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				// TODO Auto-generated method stub

				PetLostEntity petlostInfo = new PetLostEntity();

				// petlostInfo.setPetName(rs.getString("petName"));

				petlostInfo.setLoseDate(rs.getString("loseDate"));

				petlostInfo.setLoseDescribe(rs.getString("loseDescribe"));

				petlostInfo.setLoseLocation(rs.getString("loseLocation"));

				petlostInfo.setImg_url(rs.getString("img_url"));

				petlostInfo.setId(rs.getInt("id"));

				return petlostInfo;
			}
		});
	}

	public boolean addPetLostInfo(PetLostEntity petLostInfo) {
		// TODO Auto-generated method stub

		String sql = "insert into tbl_petLost(petName,petSex,petType,loseLocation,loseDate,petBirthday,rewards,loseDescribe,img_url,c_date,user_id) values(?,?,?,?,?,?,?,?,?,now(),'1')";

		return jdbcTemplate
				.update(sql,
						new Object[] { petLostInfo.getPetName(),
								petLostInfo.getPetSex(),
								petLostInfo.getPetTypeId(),
								petLostInfo.getLoseLocation(),
								petLostInfo.getLoseDate(),
								petLostInfo.getPetBirthday(),
								petLostInfo.getRewards(),
								petLostInfo.getLoseDescribe(),
								petLostInfo.getImg_url() }) > 0;

	}

}
