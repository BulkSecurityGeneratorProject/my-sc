package zw.co.elearning.school.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import zw.co.elearning.school.domain.Subject;
import zw.co.elearning.school.domain.SubjectActivity;
import zw.co.elearning.school.domain.Term;

public class SubjectActivityDTO extends AbstractAuditingDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String id;
	

	@NotNull
	private Subject subjectName;
	
	@NotNull
	private String name;

	@NotNull
	private String code;
	
	@NotNull
	private String mark;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Subject getSubjectName() {
		return subjectName;
	}
	
	public SubjectActivityDTO subjectName(Subject subjectName) {
        this.subjectName = subjectName;
        return this;
    }

	public void setSubjectName(Subject subjectName) {
		this.subjectName = subjectName;
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

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubjectActivityDTO subjectActivityDTO = (SubjectActivityDTO) o;
        if (subjectActivityDTO.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, subjectActivityDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "SubjectActivityDTO{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", code='" + code + "'" +
            ", mark='" + mark + "'" +
            '}';
    }

}
