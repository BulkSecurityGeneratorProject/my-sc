package zw.co.elearning.school.reports.tb.lists;

import java.util.Date;

public class TbPatientsTestedForHivData {
	private Date date;
	private int age;
	private String sex;
	private String fullname;
	private String address;
	private String hivStatus;
	private String tbstatus;


	
	
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHivStatus() {
		return hivStatus;
	}
	public void setHivStatus(String hivStatus) {
		this.hivStatus = hivStatus;
	}
	
	public String getTbstatus() {
		return tbstatus;
	}
	public void setTbstatus(String tbstatus) {
		this.tbstatus = tbstatus;
	}
	
	
}
