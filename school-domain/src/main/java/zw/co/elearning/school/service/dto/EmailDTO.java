package zw.co.elearning.school.service.dto;


import javax.validation.constraints.*;

import zw.co.elearning.school.service.dto.AbstractAuditingDTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the Email entity.
 */
public class EmailDTO extends AbstractAuditingDTO implements Serializable {

    private String id;

    @NotNull
    private String address;

    private String personId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

        EmailDTO emailDTO = (EmailDTO) o;

        if ( ! Objects.equals(id, emailDTO.id)) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "EmailDTO{" +
            "id=" + id +
            ", address='" + address + "'" +
            '}';
    }
}
