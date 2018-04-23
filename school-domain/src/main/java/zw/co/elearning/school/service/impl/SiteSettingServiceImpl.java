package zw.co.elearning.school.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zw.co.elearning.school.domain.SiteSetting;
import zw.co.elearning.school.repository.SiteSettingRepository;
import zw.co.elearning.school.service.SiteSettingService;
import zw.co.elearning.school.service.dto.SiteSettingDTO;
import zw.co.elearning.school.service.mapper.SiteSettingMapper;

/**
 * Service Implementation for managing SiteSetting.
 */
@Service
@Transactional
public class SiteSettingServiceImpl implements SiteSettingService{

    private final Logger log = LoggerFactory.getLogger(SiteSettingServiceImpl.class);
    
    private final SiteSettingRepository siteSettingRepository;

    private final SiteSettingMapper siteSettingMapper;

    public SiteSettingServiceImpl(SiteSettingRepository siteSettingRepository, SiteSettingMapper siteSettingMapper) {
        this.siteSettingRepository = siteSettingRepository;
        this.siteSettingMapper = siteSettingMapper;
    }

    /**
     * Save a siteSetting.
     *
     * @param siteSettingDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SiteSettingDTO save(SiteSettingDTO siteSettingDTO) {
        log.debug("Request to save SiteSetting : {}", siteSettingDTO);
        SiteSetting siteSetting = siteSettingMapper.siteSettingDTOToSiteSetting(siteSettingDTO);
        siteSetting = siteSettingRepository.save(siteSetting);
        SiteSettingDTO result = siteSettingMapper.siteSettingToSiteSettingDTO(siteSetting);
        return result;
    }

    /**
     *  Get all the siteSettings.
     *  
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<SiteSettingDTO> findAll() {
        log.debug("Request to get all SiteSettings");
        List<SiteSettingDTO> result = siteSettingRepository.findAll().stream()
            .map(siteSettingMapper::siteSettingToSiteSettingDTO)
            .collect(Collectors.toCollection(LinkedList::new));

        return result;
    }

    /**
     *  Get one siteSetting by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SiteSettingDTO findOne(String id) {
        log.debug("Request to get SiteSetting : {}", id);
        SiteSetting siteSetting = siteSettingRepository.findOne(id);
        SiteSettingDTO siteSettingDTO = siteSettingMapper.siteSettingToSiteSettingDTO(siteSetting);
        return siteSettingDTO;
    }

    /**
     *  Delete the  siteSetting by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete SiteSetting : {}", id);
        siteSettingRepository.delete(id);
    }

	@Override
	public SiteSettingDTO findSetting(String name) {
		log.debug("Request to get SiteSetting : {}", name);
        SiteSetting siteSetting = siteSettingRepository.findByName(name);
        SiteSettingDTO siteSettingDTO = siteSettingMapper.siteSettingToSiteSettingDTO(siteSetting);
        return siteSettingDTO;
	}
}
