package zw.co.elearning.school.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import zw.co.elearning.school.domain.SiteSetting;
import zw.co.elearning.school.service.dto.SiteSettingDTO;

/**
 * Mapper for the entity SiteSetting and its DTO SiteSettingDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SiteSettingMapper {

    SiteSettingDTO siteSettingToSiteSettingDTO(SiteSetting siteSetting);

    List<SiteSettingDTO> siteSettingsToSiteSettingDTOs(List<SiteSetting> siteSettings);

    SiteSetting siteSettingDTOToSiteSetting(SiteSettingDTO siteSettingDTO);

    List<SiteSetting> siteSettingDTOsToSiteSettings(List<SiteSettingDTO> siteSettingDTOs);
}
