package zw.co.elearning.school.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "subject_activity")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SubjectActivity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;
	
	@ManyToOne(optional = false)
	@NotNull
	private Subject subjectName;
	
	@NotNull
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Column(name = "code", nullable = false)
	private String code;
	
	@NotNull
	@Column(name = "mark", nullable = false)
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
	
	public SubjectActivity subjectName(Subject subjectName) {
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
        SubjectActivity subjectActivity = (SubjectActivity) o;
        if (subjectActivity.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, subjectActivity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "SubjectActivity{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", code='" + code + "'" +
            ", mark='" + mark + "'" +
            '}';
    }

}
