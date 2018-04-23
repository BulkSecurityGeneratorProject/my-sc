package zw.co.elearning.school.service.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;

public class SubjectDTO extends AbstractAuditingDTO implements Serializable{
	
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
	        SubjectDTO subject = (SubjectDTO) o;
	        if (subject.id == null || id == null) {
	            return false;
	        }
	        return Objects.equals(id, subject.id);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hashCode(id);
	    }

	    @Override
	    public String toString() {
	        return "subject{" +
	            "id=" + id +
	            ", name='" + name + "'" +
	            ", code='" + code + "'" +
	            
	            '}';
	    }
}
