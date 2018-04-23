package zw.co.elearning.school.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import io.github.jhipster.web.util.ResponseUtil;
import zw.co.elearning.school.service.SiteSettingService;
import zw.co.elearning.school.service.dto.SiteSettingDTO;
import zw.co.elearning.school.web.rest.util.HeaderUtil;

/**
 * REST controller for managing SiteSetting.
 */
@RestController
@RequestMapping("/api")
public class SiteSettingResource {

    private final Logger log = LoggerFactory.getLogger(SiteSettingResource.class);

    private static final String ENTITY_NAME = "siteSetting";
        
    private final SiteSettingService siteSettingService;

    public SiteSettingResource(SiteSettingService siteSettingService) {
        this.siteSettingService = siteSettingService;
    }

    /**
     * POST  /site-settings : Create a new siteSetting.
     *
     * @param siteSettingDTO the siteSettingDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new siteSettingDTO, or with status 400 (Bad Request) if the siteSetting has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/site-settings")
    @Timed
    public ResponseEntity<SiteSettingDTO> createSiteSetting(@Valid @RequestBody SiteSettingDTO siteSettingDTO) throws URISyntaxException {
        log.debug("REST request to save SiteSetting : {}", siteSettingDTO);
        if (siteSettingDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new siteSetting cannot already have an ID")).body(null);
        }
        SiteSettingDTO result = siteSettingService.save(siteSettingDTO);
        return ResponseEntity.created(new URI("/api/site-settings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /site-settings : Updates an existing siteSetting.
     *
     * @param siteSettingDTO the siteSettingDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated siteSettingDTO,
     * or with status 400 (Bad Request) if the siteSettingDTO is not valid,
     * or with status 500 (Internal Server Error) if the siteSettingDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/site-settings")
    @Timed
    public ResponseEntity<SiteSettingDTO> updateSiteSetting(@Valid @RequestBody SiteSettingDTO siteSettingDTO) throws URISyntaxException {
        log.debug("REST request to update SiteSetting : {}", siteSettingDTO);
        if (siteSettingDTO.getId() == null) {
            return createSiteSetting(siteSettingDTO);
        }
        SiteSettingDTO result = siteSettingService.save(siteSettingDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, siteSettingDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /site-settings : get all the siteSettings.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of siteSettings in body
     */
    @GetMapping("/site-settings")
    @Timed
    public List<SiteSettingDTO> getAllSiteSettings() {
        log.debug("REST request to get all SiteSettings");
        return siteSettingService.findAll();
    }

    /**
     * GET  /site-settings/:id : get the "id" siteSetting.
     *
     * @param id the id of the siteSettingDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the siteSettingDTO, or with status 404 (Not Found)
     */
    @GetMapping("/site-settings/{name}")
    @Timed
    public ResponseEntity<SiteSettingDTO> getSiteSetting(@PathVariable String name) {
        log.debug("REST request to get SiteSetting : {}", name);
        SiteSettingDTO siteSettingDTO = siteSettingService.findSetting(name);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(siteSettingDTO));
    }

    /**
     * DELETE  /site-settings/:id : delete the "id" siteSetting.
     *
     * @param id the id of the siteSettingDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/site-settings/{id}")
    @Timed
    public ResponseEntity<Void> deleteSiteSetting(@PathVariable String id) {
        log.debug("REST request to delete SiteSetting : {}", id);
        siteSettingService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
