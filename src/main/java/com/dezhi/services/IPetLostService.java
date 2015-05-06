package com.dezhi.services;

import java.util.List;

import com.dezhi.entity.PetLostEntity;


/**
 * 宠物丢失信息记录
 * @author dezhi1231
 *
 */
public interface IPetLostService {
	
	
	/**
	 * 查询宠物丢失信息
	 * @param page 分頁
	 * @param location 根据地址检索
	 * @return
	 */
	public List<PetLostEntity> queryPetLostInfo(int page,String location);
	
	/**
	 * 添加宠物丢失信息
	 * @param petLostInfo
	 * @return
	 */
	public boolean addPetLostInfo(PetLostEntity petLostInfo);
	

}
