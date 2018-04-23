package zw.co.elearning.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.elearning.school.domain.SiteSetting;

/**
 * Spring Data JPA repository for the SiteSetting entity.
 */
@SuppressWarnings("unused")
public interface SiteSettingRepository extends JpaRepository<SiteSetting,String> {

	SiteSetting findByName(String name);

}
