package com.appsstuff.demo.security;


public class Organaziation {

	private Integer id;
	private String OrgName;
	private String OrgLocation;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrgName() {
		return OrgName;
	}
	public void setOrgName(String orgName) {
		OrgName = orgName;
	}
	public String getOrgLocation() {
		return OrgLocation;
	}
	public void setOrgLocation(String orgLocation) {
		OrgLocation = orgLocation;
	}
	public Organaziation(Integer id, String orgName, String orgLocation) {
		super();
		this.id = id;
		OrgName = orgName;
		OrgLocation = orgLocation;
	}
	
	public Organaziation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Organaziation [id=" + id + ", OrgName=" + OrgName + ", OrgLocation=" + OrgLocation + "]";
	}
	
}
