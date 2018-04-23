package zw.co.elearning.school.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import zw.co.elearning.school.domain.GradeName;

public class GradeNameDTO extends AbstractAuditingDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	@NotNull
    private String name;
	
	@NotNull
    private String code;
	
	
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

	
	@Override
	    public boolean equals(Object o) {
	        if (this == o) {
	            return true;
	        }
	        if (o == null || getClass() != o.getClass()) {
	            return false;
	        }
	        GradeNameDTO gradeName = (GradeNameDTO) o;
	        if (gradeName.id == null || id == null) {
	            return false;
	        }
	        return Objects.equals(id, gradeName.id);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hashCode(id);
	    }

	    @Override
	    public String toString() {
	        return "GradeNameDTO{" +
	            "id=" + id +
	            ", name='" + name + "'" +
	            ", code='" + code + "'" +
	            '}';
	    }

}
