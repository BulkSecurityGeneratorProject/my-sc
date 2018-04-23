package zw.co.elearning.school.reports.lists;

import java.util.Date;

public class InfantsBornSameMonthtData {

	private Date date;
	private String fullname;
	private int birthweight;
	private String sex;
	private String delivery_method;
	private String immunisation;
	private String address;
	private int age;
	private String ageMonths;

	public String getAgeMonths() {
		return ageMonths;
	}

	public void setAgeMonths(String ageMonths) {
		this.ageMonths = ageMonths;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getImmunisation() {
		return immunisation;
	}

	public void setImmunisation(String immunisation) {
		this.immunisation = immunisation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBirthweight() {
		return birthweight;
	}

	public void setBirthweight(int birthweight) {
		this.birthweight = birthweight;
	}

	public String getDelivery_method() {
		return delivery_method;
	}

	public void setDelivery_method(String delivery_method) {
		this.delivery_method = delivery_method;
	}

}
