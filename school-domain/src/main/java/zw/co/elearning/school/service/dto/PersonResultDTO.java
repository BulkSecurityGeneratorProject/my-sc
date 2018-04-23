package zw.co.elearning.school.service.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;

public class PersonResultDTO {
	
	private String id;

	
	@NotNull
	private String termId;

	@NotNull
	private String personId;

	@NotNull
	private String classNameId;
	
	@NotNull
	private String subjectActivityId;
	
	@NotNull
	private int mark;
	
	@NotNull
	private int possibleMark;
	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTermId() {
		return termId;
	}

	public void setTermId(String termId) {
		this.termId = termId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getClassNameId() {
		return classNameId;
	}

	public void setClassNameId(String classNameId) {
		this.classNameId = classNameId;
	}

	public String getSubjectActivityId() {
		return subjectActivityId;
	}

	public void setSubjectActivityId(String subjectActivityId) {
		this.subjectActivityId = subjectActivityId;
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
		PersonResultDTO personResult = (PersonResultDTO) o;
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
