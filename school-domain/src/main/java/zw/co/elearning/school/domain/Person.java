package zw.co.elearning.school.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import zw.co.elearning.school.domain.enumeration.Gender;

/**
 * A Person.
 */
@Entity
@Table(name = "person")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Person extends AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	@NotNull
	@Column(name = "lastname", nullable = false)
	private String lastname;

	@NotNull
	@Column(name = "firstname", nullable = false)
	private String firstname;

	@ManyToOne(optional = false)
		@NotNull
	private ClassName className;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "sex", nullable = false)
	private Gender sex;

	@NotNull
	@Column(name = "birthdate", nullable = false)
	private LocalDate birthdate;

	@OneToMany(mappedBy = "person")
	@JsonIgnore
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<Address> addresses = new HashSet<>();

	@OneToMany(mappedBy = "person")
	@JsonIgnore
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<Phone> phones = new HashSet<>();

	@OneToMany(mappedBy = "person")
	@JsonIgnore
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<Email> emails = new HashSet<>();

	@OneToMany(mappedBy = "person")
	@JsonIgnore
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<PersonAllergy> allergies = new HashSet<>();

	public Person(String id) {
		this.id = id;
	}

	public Person() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public Person lastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public Person firstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Gender getSex() {
		return sex;
	}

	public Person sex(Gender sex) {
		this.sex = sex;
		return this;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public Person birthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
		return this;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public Person addresses(Set<Address> addresses) {
		this.addresses = addresses;
		return this;
	}

	public Person addAddresses(Address address) {
		this.addresses.add(address);
		address.setPerson(this);
		return this;
	}

	public Person removeAddresses(Address address) {
		this.addresses.remove(address);
		address.setPerson(null);
		return this;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public Person phones(Set<Phone> phones) {
		this.phones = phones;
		return this;
	}

	public Person addPhones(Phone phone) {
		this.phones.add(phone);
		phone.setPerson(this);
		return this;
	}

	public Person removePhones(Phone phone) {
		this.phones.remove(phone);
		phone.setPerson(null);
		return this;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public Set<Email> getEmails() {
		return emails;
	}

	public Person emails(Set<Email> emails) {
		this.emails = emails;
		return this;
	}

	public Person addEmails(Email email) {
		this.emails.add(email);
		email.setPerson(this);
		return this;
	}

	public Person removeEmails(Email email) {
		this.emails.remove(email);
		email.setPerson(null);
		return this;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}

	public Set<PersonAllergy> getAllergies() {
		return allergies;
	}

	public void setAllergies(Set<PersonAllergy> allergies) {
		this.allergies = allergies;
	}

	public ClassName getClassName() {
		return className;
	}

	public Person className(ClassName classname) {
		this.className = classname;
		return this;
	}

	public void setClassName(ClassName classname) {
		this.className = classname;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Person person = (Person) o;
		if (person.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, person.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "Person{" + "id=" + id + ", lastname='" + lastname + "'" + ", firstname='" + firstname + "'" + ", sex='"
				+ sex + "'" + ", birthdate='" + birthdate + "'" + '}';
	}
}
