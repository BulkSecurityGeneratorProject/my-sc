package zw.co.elearning.school.service.dto;


import javax.validation.constraints.*;

import zw.co.elearning.school.service.dto.AbstractAuditingDTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the Address entity.
 */
public class AddressDTO extends AbstractAuditingDTO implements Serializable {

    private String id;

    @NotNull
    private String street;

    private String city;

    private String town;

    private String personId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

        AddressDTO addressDTO = (AddressDTO) o;

        if ( ! Objects.equals(id, addressDTO.id)) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
            "id=" + id +
            ", street='" + street + "'" +
            ", city='" + city + "'" +
            ", town='" + town + "'" +
            '}';
    }
}
