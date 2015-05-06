package com.dezhi.services;

import java.util.List;

import com.dezhi.entity.PetTypeEntity;


/**
 * 宠物类别业务
 * @author dezhi1231
 *
 */
public interface IPetTypeService {

	/**
	 * 根据类型id查询宠物类型
	 * @param typeId
	 * @return
	 */
	public List<PetTypeEntity> queryPetTypeByTypeId(int typeId);
	
	
	
	
}
