package com.dezhi.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;
import com.dezhi.entity.PetAdoptEntity;

public class PetAdoptService implements IPetAdoptService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<PetAdoptEntity> findPetAdoptList(int page, int petType,
			int petSex, String location) {
		// TODO Auto-generated method stub

		String sql = "select * from tbl_petAdopt where 1=1 ";

		if (!StringUtils.isEmpty(location)) {
			sql += " and location = '" + location + "'";
		}

		if (petType != 0) {
			sql += " and petType = " + petType;
		}

		if (petSex != 0) {
			sql += " and petSex = " + petSex;
		}

		sql += " order by id desc ";

		if (page == 0) {
			sql += " limit 0,10";
		} else {

			int s = ((page - 1) * 3) + 10;

			sql += " limit " + s + ",3";

		}

		return jdbcTemplate.query(sql, new RowMapper<PetAdoptEntity>() {

			public PetAdoptEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				// TODO Auto-generated method stub

				PetAdoptEntity petAdoptEntity = new PetAdoptEntity();

				petAdoptEntity.setId(rs.getInt("id"));

				petAdoptEntity.setImg(rs.getString("img"));

				return petAdoptEntity;
			}
		});

	}

	public PetAdoptEntity findPetAdoptById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addPetAdoptInfo(PetAdoptEntity petAdopt) {
		// TODO Auto-generated method stub
		return false;
	}

}
