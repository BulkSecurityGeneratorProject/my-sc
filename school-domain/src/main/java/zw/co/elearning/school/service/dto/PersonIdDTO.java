package zw.co.elearning.school.service.dto;


import javax.validation.constraints.*;

import zw.co.elearning.school.service.dto.AbstractAuditingDTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the PersonId entity.
 */
public class PersonIdDTO extends AbstractAuditingDTO implements Serializable {

    private Long id;

    @NotNull
    private String number;

    private Long typeId;

    private String personId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long personIdentifierId) {
        this.typeId = personIdentifierId;
    }

    

    public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PersonIdDTO personIdDTO = (PersonIdDTO) o;

        if ( ! Objects.equals(id, personIdDTO.id)) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "PersonIdDTO{" +
            "id=" + id +
            ", number='" + number + "'" +
            '}';
    }
}
