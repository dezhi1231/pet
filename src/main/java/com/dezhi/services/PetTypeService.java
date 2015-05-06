package com.dezhi.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.dezhi.entity.PetTypeEntity;

public class PetTypeService implements IPetTypeService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<PetTypeEntity> queryPetTypeByTypeId(int typeId) {

		String sql = "select * from tbl_petType where typeId = ?";

		return jdbcTemplate.query(sql,new Object[]{typeId}, new RowMapper<PetTypeEntity>() {

			public PetTypeEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				PetTypeEntity petTypeEntity = new PetTypeEntity();

				petTypeEntity.setId(rs.getInt("id"));

				petTypeEntity.setTypeId(rs.getInt("typeId"));

				petTypeEntity.setTypeName(rs.getString("typeName"));

				return petTypeEntity;
			}
		});
	}

}
