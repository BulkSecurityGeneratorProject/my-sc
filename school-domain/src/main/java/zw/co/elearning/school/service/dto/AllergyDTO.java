package zw.co.elearning.school.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the Allergy entity.
 */
public class AllergyDTO extends AbstractAuditingDTO implements Serializable {

    private String id;

    @NotNull
    private String name;


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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AllergyDTO allergyDTO = (AllergyDTO) o;

        if ( ! Objects.equals(id, allergyDTO.id)) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "AllergyDTO{" +
            "id=" + id +
            ", name='" + name + "'" +
            '}';
    }
}
