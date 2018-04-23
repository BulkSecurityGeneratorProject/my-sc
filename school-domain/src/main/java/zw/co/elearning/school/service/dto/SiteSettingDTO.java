package zw.co.elearning.school.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the SiteSetting entity.
 */
public class SiteSettingDTO implements Serializable {

    private String id;

    @NotNull
    private String name;

    @NotNull
    private String value;

    private String meta;

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
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public String getMeta() {
        return meta;
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

        SiteSettingDTO siteSettingDTO = (SiteSettingDTO) o;

        if ( ! Objects.equals(id, siteSettingDTO.id)) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "SiteSettingDTO{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", value='" + value + "'" +
            ", meta='" + meta + "'" +
            '}';
    }
}
