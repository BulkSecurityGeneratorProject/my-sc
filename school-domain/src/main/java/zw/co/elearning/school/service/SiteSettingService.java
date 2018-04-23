package zw.co.elearning.school.service;

import zw.co.elearning.school.service.dto.SiteSettingDTO;
import java.util.List;

/**
 * Service Interface for managing SiteSetting.
 */
public interface SiteSettingService {
	
	String SITE_CODE = "SITE_CODE";

	/**
	 * Save a siteSetting.
	 *
	 * @param siteSettingDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	SiteSettingDTO save(SiteSettingDTO siteSettingDTO);

	/**
	 * Get all the siteSettings.
	 * 
	 * @return the list of entities
	 */
	List<SiteSettingDTO> findAll();

	/**
	 * Get the "id" siteSetting.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	SiteSettingDTO findOne(String id);

	/**
	 * Delete the "id" siteSetting.
	 *
	 * @param id
	 *            the id of the entity
	 */
	void delete(String id);

	SiteSettingDTO findSetting(String name);
}
