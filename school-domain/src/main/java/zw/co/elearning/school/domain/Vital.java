package zw.co.elearning.school.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Vital.
 */
@Entity
@Table(name = "vital")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Vital extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "minimum")
    private Double minimum;

    @Column(name = "maximum")
    private Double maximum;

    @ManyToOne(optional = false)
    @NotNull
    private Standard standard;

    @ManyToOne(optional = false)
    @NotNull
    private Unit unit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Vital name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public Vital code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getMinimum() {
        return minimum;
    }

    public Vital minimum(Double minimum) {
        this.minimum = minimum;
        return this;
    }

    public void setMinimum(Double minimum) {
        this.minimum = minimum;
    }

    public Double getMaximum() {
        return maximum;
    }

    public Vital maximum(Double maximum) {
        this.maximum = maximum;
        return this;
    }

    public void setMaximum(Double maximum) {
        this.maximum = maximum;
    }

    public Standard getStandard() {
        return standard;
    }

    public Vital standard(Standard standard) {
        this.standard = standard;
        return this;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public Unit getUnit() {
        return unit;
    }

    public Vital unit(Unit unit) {
        this.unit = unit;
        return this;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vital vital = (Vital) o;
        if (vital.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, vital.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Vital{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", code='" + code + "'" +
            ", minimum='" + minimum + "'" +
            ", maximum='" + maximum + "'" +
            '}';
    }
}
