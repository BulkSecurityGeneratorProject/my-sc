package zw.co.elearning.school.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import zw.co.elearning.school.service.dto.AbstractAuditingDTO;

/**
 * A DTO for the PersonVital entity.
 */
public class PersonVitalDTO extends AbstractAuditingDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDateTime date;
    
    private String value;

    private String personId;

    private String vitalId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    

    public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getVitalId() {
		return vitalId;
	}

	public void setVitalId(String vitalId) {
		this.vitalId = vitalId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PersonVitalDTO personVitalDTO = (PersonVitalDTO) o;

        if ( ! Objects.equals(id, personVitalDTO.id)) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "PersonVitalDTO{" +
            "id=" + id +
            ", date='" + date + "'" +
            ", value='" + value + "'" +
            '}';
    }
}
