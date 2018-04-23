package zw.co.elearning.school.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the Vital entity.
 */
public class VitalDTO extends AbstractAuditingDTO implements Serializable {

    private String id;

    @NotNull
    private String name;

    @NotNull
    private String code;

    private Double minimum;

    private Double maximum;

    private String standardId;

    private String unitId;

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
    public Double getMinimum() {
        return minimum;
    }

    public void setMinimum(Double minimum) {
        this.minimum = minimum;
    }
    public Double getMaximum() {
        return maximum;
    }

    public void setMaximum(Double maximum) {
        this.maximum = maximum;
    }

    public String getStandardId() {
        return standardId;
    }

    public void setStandardId(String standardId) {
        this.standardId = standardId;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VitalDTO vitalDTO = (VitalDTO) o;

        if ( ! Objects.equals(id, vitalDTO.id)) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "VitalDTO{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", code='" + code + "'" +
            ", minimum='" + minimum + "'" +
            ", maximum='" + maximum + "'" +
            '}';
    }
}
