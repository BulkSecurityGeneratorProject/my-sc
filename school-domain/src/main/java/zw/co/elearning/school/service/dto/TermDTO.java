package zw.co.elearning.school.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import zw.co.elearning.school.domain.Term;

public class TermDTO extends AbstractAuditingDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	@NotNull
    private String name;
	
	@NotNull
    private String code;
	
	
	@NotNull
	private String year;
	
	@NotNull
	private LocalDate start;
	
	@NotNull
	private LocalDate end;
	
	
	
	
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	@Override
	    public boolean equals(Object o) {
	        if (this == o) {
	            return true;
	        }
	        if (o == null || getClass() != o.getClass()) {
	            return false;
	        }
	        TermDTO term = (TermDTO) o;
	        if (term.id == null || id == null) {
	            return false;
	        }
	        return Objects.equals(id, term.id);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hashCode(id);
	    }

	    @Override
	    public String toString() {
	        return "TermDTO{" +
	            "id=" + id +
	            ", name='" + name + "'" +
	            ", code='" + code + "'" +
	            ", year='" + year + "'" +
	            ", start='" + start + "'" +
	            ", end='" + end + "'" +
	            '}';
	    }

}
