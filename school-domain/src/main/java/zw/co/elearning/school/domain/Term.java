package zw.co.elearning.school.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "term")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Term  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;
	
	@NotNull
    @Column(name = "name", nullable = false)
    private String name;
	
	@NotNull
    @Column(name = "code", nullable = false)
    private String code;
	
	
	@NotNull
	@Column(name = "year", nullable = false)
	private String year;
	
	@NotNull
	@Column(name = "start", nullable = false)
	private LocalDate start;
	
	@NotNull
	@Column(name = "end", nullable = false)
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
	        Term term = (Term) o;
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
	        return "Term{" +
	            "id=" + id +
	            ", name='" + name + "'" +
	            ", code='" + code + "'" +
	            ", year='" + year + "'" +
	            ", start='" + start + "'" +
	            ", end='" + end + "'" +
	            '}';
	    }

}
