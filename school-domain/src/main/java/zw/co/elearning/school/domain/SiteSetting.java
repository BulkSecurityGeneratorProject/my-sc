package zw.co.elearning.school.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A SiteSetting.
 */
@Entity
@Table(name = "site_setting")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SiteSetting implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@NotNull
	@Column(name = "value", nullable = false)
	private String value;

	@Column(name = "meta")
	private String meta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public SiteSetting name(String name) {
		this.name = name;
		return this;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public SiteSetting value(String value) {
		this.value = value;
		return this;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMeta() {
		return meta;
	}

	public SiteSetting meta(String meta) {
		this.meta = meta;
		return this;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SiteSetting siteSetting = (SiteSetting) o;
		if (siteSetting.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, siteSetting.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "SiteSetting{" + "id=" + id + ", name='" + name + "'" + ", value='" + value + "'" + ", meta='" + meta
				+ "'" + '}';
	}
}
