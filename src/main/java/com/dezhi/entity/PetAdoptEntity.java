package com.dezhi.entity;


/**
 * 宠物领养 记录
 * @author dezhi1231
 *
 */
public class PetAdoptEntity {
	
	private int id;
	
	private String user_id;
	
	private String c_date;
	
	private int adoptStatus;
	
	private String adopt_id;
	
	private int petTypeId;
	
	private int petSex;
	
	private String petBirthday;
	
	private int sterilisation;
	
	private int vaccineStatus;
	
	private int returnVisit;
	
	private int cityWide;
	
	private String location;
	
	private String note;
	
	private int openContact;
	
	/**
	 * 配图
	 */
	private String img;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getC_date() {
		return c_date;
	}

	public void setC_date(String c_date) {
		this.c_date = c_date;
	}

	public int getAdoptStatus() {
		return adoptStatus;
	}

	public void setAdoptStatus(int adoptStatus) {
		this.adoptStatus = adoptStatus;
	}

	public String getAdopt_id() {
		return adopt_id;
	}

	public void setAdopt_id(String adopt_id) {
		this.adopt_id = adopt_id;
	}

	public int getPetTypeId() {
		return petTypeId;
	}

	public void setPetTypeId(int petTypeId) {
		this.petTypeId = petTypeId;
	}

	public int getPetSex() {
		return petSex;
	}

	public void setPetSex(int petSex) {
		this.petSex = petSex;
	}

	public String getPetBirthday() {
		return petBirthday;
	}

	public void setPetBirthday(String petBirthday) {
		this.petBirthday = petBirthday;
	}

	public int getSterilisation() {
		return sterilisation;
	}

	public void setSterilisation(int sterilisation) {
		this.sterilisation = sterilisation;
	}

	public int getVaccineStatus() {
		return vaccineStatus;
	}

	public void setVaccineStatus(int vaccineStatus) {
		this.vaccineStatus = vaccineStatus;
	}

	public int getReturnVisit() {
		return returnVisit;
	}

	public void setReturnVisit(int returnVisit) {
		this.returnVisit = returnVisit;
	}

	public int getCityWide() {
		return cityWide;
	}

	public void setCityWide(int cityWide) {
		this.cityWide = cityWide;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getOpenContact() {
		return openContact;
	}

	public void setOpenContact(int openContact) {
		this.openContact = openContact;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	

}
