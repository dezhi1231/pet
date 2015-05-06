package com.dezhi.entity;


/**
 * 宠物丢失信息实体类
 * @author dezhi1231
 *
 */
public class PetLostEntity {
	
	private int id;
	
	
	/**
	 * 宠物昵称 
	 */
	private String petName;
	
	
	/**
	 * 宠物性别
	 */
	private int petSex; 
	
	
	/**
	 * 宠物类型
	 */
	private int petTypeId;
	
	
	/**
	 * 丢失地点
	 */
	private String loseLocation;
	
	
	
	/**
	 * 丢失时间
	 */
	private String loseDate;
	
	
	/**
	 * 宠物生日
	 */
	private String petBirthday;
	
	
	/**
	 * 悬赏金额
	 */
	private float rewards;
	
	
	/**
	 * 丢失描述
	 */
	private String loseDescribe;
	
	
	/**
	 * 宠物图像信息
	 */
	private String img_url;
	
	
	/**
	 * 信息添加时间
	 */
	private String c_date;
	
	/**
	 * 绑定微信  用户信息
	 */
	private String user_id;

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public int getPetSex() {
		return petSex;
	}

	public void setPetSex(int petSex) {
		this.petSex = petSex;
	}

	public int getPetTypeId() {
		return petTypeId;
	}

	public void setPetTypeId(int petTypeId) {
		this.petTypeId = petTypeId;
	}

	public String getLoseLocation() {
		return loseLocation;
	}

	public void setLoseLocation(String loseLocation) {
		this.loseLocation = loseLocation;
	}

	public String getLoseDate() {
		return loseDate;
	}

	public void setLoseDate(String loseDate) {
		this.loseDate = loseDate;
	}

	public String getPetBirthday() {
		return petBirthday;
	}

	public void setPetBirthday(String petBirthday) {
		this.petBirthday = petBirthday;
	}

	public float getRewards() {
		return rewards;
	}

	public void setRewards(float rewards) {
		this.rewards = rewards;
	}

	public String getLoseDescribe() {
		return loseDescribe;
	}

	public void setLoseDescribe(String loseDescribe) {
		this.loseDescribe = loseDescribe;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getC_date() {
		return c_date;
	}

	public void setC_date(String c_date) {
		this.c_date = c_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
 
}
