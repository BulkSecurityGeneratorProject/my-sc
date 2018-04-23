package zw.co.elearning.school.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
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
import zw.co.elearning.school.service.PersonAllergyService;
import zw.co.elearning.school.service.dto.PersonAllergyDTO;
import zw.co.elearning.school.web.rest.util.HeaderUtil;

/**
 * REST controller for managing PersonAllergy.
 */
@RestController
@RequestMapping("/api")
public class PersonAllergyResource {

    private final Logger log = LoggerFactory.getLogger(PersonAllergyResource.class);

    private static final String ENTITY_NAME = "personAllergy";
        
    private final PersonAllergyService personAllergyService;

    public PersonAllergyResource(PersonAllergyService personAllergyService) {
        this.personAllergyService = personAllergyService;
    }

    /**
     * POST  /person-allergies : Create a new personAllergy.
     *
     * @param personAllergyDTO the personAllergyDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new personAllergyDTO, or with status 400 (Bad Request) if the personAllergy has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/person-allergies")
    @Timed
    public ResponseEntity<PersonAllergyDTO> createPersonAllergy(@Valid @RequestBody PersonAllergyDTO personAllergyDTO) throws URISyntaxException {
        log.debug("REST request to save PersonAllergy : {}", personAllergyDTO);
        if (personAllergyDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new personAllergy cannot already have an ID")).body(null);
        }
        PersonAllergyDTO result = personAllergyService.save(personAllergyDTO);
        return ResponseEntity.created(new URI("/api/person-allergies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /person-allergies : Updates an existing personAllergy.
     *
     * @param personAllergyDTO the personAllergyDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated personAllergyDTO,
     * or with status 400 (Bad Request) if the personAllergyDTO is not valid,
     * or with status 500 (Internal Server Error) if the personAllergyDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/person-allergies")
    @Timed
    public ResponseEntity<PersonAllergyDTO> updatePersonAllergy(@Valid @RequestBody PersonAllergyDTO personAllergyDTO) throws URISyntaxException {
        log.debug("REST request to update PersonAllergy : {}", personAllergyDTO);
        if (personAllergyDTO.getId() == null) {
            return createPersonAllergy(personAllergyDTO);
        }
        PersonAllergyDTO result = personAllergyService.save(personAllergyDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, personAllergyDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /person-allergies/:id : get the "id" personAllergy.
     *
     * @param id the id of the personAllergyDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the personAllergyDTO, or with status 404 (Not Found)
     */
    @GetMapping("/person-allergies/{id}")
    @Timed
    public ResponseEntity<PersonAllergyDTO> getPersonAllergy(@PathVariable Long id) {
        log.debug("REST request to get PersonAllergy : {}", id);
        PersonAllergyDTO personAllergyDTO = personAllergyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(personAllergyDTO));
    }

    /**
     * DELETE  /person-allergies/:id : delete the "id" personAllergy.
     *
     * @param id the id of the personAllergyDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/person-allergies/{id}")
    @Timed
    public ResponseEntity<Void> deletePersonAllergy(@PathVariable Long id) {
        log.debug("REST request to delete PersonAllergy : {}", id);
        personAllergyService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
