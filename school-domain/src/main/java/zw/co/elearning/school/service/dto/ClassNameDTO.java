package zw.co.elearning.school.service.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import zw.co.elearning.school.domain.GradeName;

public class ClassNameDTO extends AbstractAuditingDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private String id;

	@NotNull
	private String name;

	@NotNull
	private String code;

	@NotNull
	private String gradeNameId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

	public String getGradeNameId() {
		return gradeNameId;
	}

	public void setGradeNameId(String gradeNameId) {
		this.gradeNameId = gradeNameId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ClassNameDTO className = (ClassNameDTO) o;
		if (className.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, className.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "ClassName [id=" + id + ", name=" + name + ", code=" + code + ", gradeNameId=" + gradeNameId + "]";
	}

}
