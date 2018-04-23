package zw.co.elearning.school.reports.lists;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImmunisationData {
	
	private String firstname;
	private String lastname;
	private int age;
	private String sex;
	private String address;
	
	private List<Immunisation> medications=new ArrayList<>();
	
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	
	
	
	public List<Immunisation> getMedications() {
		return medications;
	}
	
	public void setMedications(List<Immunisation> medications) {
		this.medications = medications;
	}

	
}
