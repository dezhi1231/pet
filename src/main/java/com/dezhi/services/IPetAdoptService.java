package com.dezhi.services;

import java.util.List;

import com.dezhi.entity.PetAdoptEntity;



/**
 * 领养操作
 * @author dezhi1231
 *
 */
public interface IPetAdoptService {
	
	/**
	 * 
	 * @param page
	 * @param petType
	 * @param petSex
	 * @param location
	 * @return
	 */
	public List<PetAdoptEntity> findPetAdoptList(int page,int petType,int petSex,String location);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public PetAdoptEntity findPetAdoptById(int id);
	
	/**
	 * 添加
	 * @param petAdopt
	 * @return
	 */
	public boolean addPetAdoptInfo(PetAdoptEntity petAdopt);

}
