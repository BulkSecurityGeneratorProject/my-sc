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
@Table(name = "person_result")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PersonResult extends AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	@ManyToOne(optional = false)
	@NotNull
	private Term term;

	@ManyToOne(optional = false)
	@NotNull
	private Person person;

	@ManyToOne(optional = false)
	@NotNull
	private ClassName className;
	
	@ManyToOne(optional = false)
	@NotNull
	private SubjectActivity subjectActivity;
	
	@NotNull
	@Column(name = "mark", nullable = false)
	private int mark;
	
	@NotNull
	@Column(name = "possible_mark", nullable = false)
	private int possibleMark;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Term getTerm() {
		return term;
	}
	
	public PersonResult term(Term term) {
		this.term = term;
		return this;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public Person getPerson() {
		return person;
	}
	
	public PersonResult person(Person person) {
		this.person = person;
		return this;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public ClassName getClassName() {
		return className;
	}
	
	public PersonResult className(ClassName className) {
		this.className = className;
		return this;
	}

	public void setClassName(ClassName className) {
		this.className = className;
	}

	public SubjectActivity getSubjectActivity() {
		return subjectActivity;
	}
	
	public PersonResult subjectActivity(SubjectActivity subjectActivity) {
		this.subjectActivity = subjectActivity;
		return this;
	}

	public void setSubjectActivity(SubjectActivity subjectActivity) {
		this.subjectActivity = subjectActivity;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getPossibleMark() {
		return possibleMark;
	}

	public void setPossibleMark(int possibleMark) {
		this.possibleMark = possibleMark;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PersonResult personResult = (PersonResult) o;
		if (personResult.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, personResult.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}


	@Override
	public String toString() {
		return "PersonResult{" + "id=" + id + ", mark='" + mark + "'" + ", possibleMark='" + possibleMark + "'"  + '}';
	}
	
	
	
	

}
