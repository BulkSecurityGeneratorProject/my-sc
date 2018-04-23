package zw.co.elearning.school.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A PersonAllergy.
 */
@Entity
@Table(name = "person_allergy")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PersonAllergy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @NotNull
    private Person person;

    @ManyToOne(optional = false)
    @NotNull
    private Allergy allergy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public PersonAllergy person(Person person) {
        this.person = person;
        return this;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Allergy getAllergy() {
        return allergy;
    }

    public PersonAllergy allergy(Allergy allergy) {
        this.allergy = allergy;
        return this;
    }

    public void setAllergy(Allergy allergy) {
        this.allergy = allergy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonAllergy personAllergy = (PersonAllergy) o;
        if (personAllergy.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, personAllergy.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "PersonAllergy{" +
            "id=" + id +
            '}';
    }
}
