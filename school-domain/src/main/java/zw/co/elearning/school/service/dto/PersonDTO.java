package zw.co.elearning.school.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import zw.co.elearning.school.domain.enumeration.Gender;



/**
 * A DTO for the Person entity.
 */
public class PersonDTO extends AbstractAuditingDTO implements Serializable {

	private String id;

	@NotNull
	private String lastname;

	@NotNull
	private String firstname;

	@NotNull
	private Gender sex;

	@NotNull
	private LocalDate birthdate;
	
	@NotNull
	private String classNameId;

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Gender getSex() {
		return sex;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}	

	public String getClassNameId() {
		return classNameId;
	}

	public void setClassNameId(String classNameId) {
		this.classNameId = classNameId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		PersonDTO personDTO = (PersonDTO) o;

		if (!Objects.equals(id, personDTO.id)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "PersonDTO{" + "id=" + id + ", lastname='" + lastname + "'" + ", firstname='" + firstname + "'"
				+ ", sex='" + sex + "'" + ", birthdate='" + birthdate + "'" 
				+ '}';
	}
}
