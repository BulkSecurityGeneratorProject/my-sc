package zw.co.elearning.school.reports.dto;

import java.util.Date;

public class MalariaRegisterDTO {
	private Date date;
	private String name;
	private String address;
	private int age;
	private String sex;
	private Date dateOnSet;
	private String result;
	private String medication;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Date getDateOnSet() {
		return dateOnSet;
	}

	public void setDateOnSet(Date dateOnSet) {
		this.dateOnSet = dateOnSet;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

}
