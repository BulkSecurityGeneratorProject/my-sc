package zw.co.elearning.school.service.dto;


import javax.validation.constraints.*;

import zw.co.elearning.school.service.dto.AbstractAuditingDTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the Phone entity.
 */
public class PhoneDTO extends AbstractAuditingDTO implements Serializable {

    private Long id;

    @NotNull
    private String number;

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

        PhoneDTO phoneDTO = (PhoneDTO) o;

        if ( ! Objects.equals(id, phoneDTO.id)) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "PhoneDTO{" +
            "id=" + id +
            ", number='" + number + "'" +
            '}';
    }
}
