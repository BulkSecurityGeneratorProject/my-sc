package zw.co.elearning.school.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.ApiParam;
import zw.co.elearning.school.service.PersonVitalService;
import zw.co.elearning.school.service.dto.PersonVitalDTO;
import zw.co.elearning.school.web.rest.util.HeaderUtil;
import zw.co.elearning.school.web.rest.util.PaginationUtil;

/**
 * REST controller for managing PersonVital.
 */
@RestController
@RequestMapping("/api")
public class PersonVitalResource {

	private final Logger log = LoggerFactory.getLogger(PersonVitalResource.class);

	private static final String ENTITY_NAME = "personVital";

	private final PersonVitalService personVitalService;

	public PersonVitalResource(PersonVitalService personVitalService) {
		this.personVitalService = personVitalService;
	}

	/**
	 * POST /person-vitals : Create a new personVital.
	 *
	 * @param personVitalDTO
	 *            the personVitalDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new personVitalDTO, or with status 400 (Bad Request) if the
	 *         personVital has already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/person-vitals")
	@Timed
	public ResponseEntity<PersonVitalDTO> createPersonVital(@Valid @RequestBody PersonVitalDTO personVitalDTO)
			throws URISyntaxException {
		log.debug("REST request to save PersonVital : {}", personVitalDTO);
		if (personVitalDTO.getId() != null) {
			return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists",
					"A new personVital cannot already have an ID")).body(null);
		}
		PersonVitalDTO result = personVitalService.save(personVitalDTO);
		return ResponseEntity.created(new URI("/api/person-vitals/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /person-vitals : Updates an existing personVital.
	 *
	 * @param personVitalDTO
	 *            the personVitalDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         personVitalDTO, or with status 400 (Bad Request) if the
	 *         personVitalDTO is not valid, or with status 500 (Internal Server
	 *         Error) if the personVitalDTO couldnt be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/person-vitals")
	@Timed
	public ResponseEntity<PersonVitalDTO> updatePersonVital(@Valid @RequestBody PersonVitalDTO personVitalDTO)
			throws URISyntaxException {
		log.debug("REST request to update PersonVital : {}", personVitalDTO);
		if (personVitalDTO.getId() == null) {
			return createPersonVital(personVitalDTO);
		}
		PersonVitalDTO result = personVitalService.save(personVitalDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, personVitalDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /person-vitals : get all the personVitals.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of
	 *         personVitals in body
	 * @throws URISyntaxException
	 *             if there is an error to generate the pagination HTTP headers
	 */
	@GetMapping("/person-vitals")
	@Timed
	public ResponseEntity<List<PersonVitalDTO>> getAllPersonVitals(@ApiParam Pageable pageable)
			throws URISyntaxException {
		log.debug("REST request to get a page of PersonVitals");
		Page<PersonVitalDTO> page = personVitalService.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/person-vitals");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	@GetMapping("/person-vitals/vitals")
	@Timed
	public ResponseEntity<List<PersonVitalDTO>> getByIds(
			@RequestParam(value = "personVitalId", required = true) String[] ids) throws URISyntaxException {
		log.debug("REST request to get a page of PersonVitals");
		List<PersonVitalDTO> result = personVitalService.findByIds(ids);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * GET /person-vitals/:id : get the "id" personVital.
	 *
	 * @param id
	 *            the id of the personVitalDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         personVitalDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/person-vitals/{id}")
	@Timed
	public ResponseEntity<PersonVitalDTO> getPersonVital(@PathVariable String id) {
		log.debug("REST request to get PersonVital : {}", id);
		PersonVitalDTO personVitalDTO = personVitalService.findOne(id);
		return ResponseUtil.wrapOrNotFound(Optional.ofNullable(personVitalDTO));
	}

	/**
	 * DELETE /person-vitals/:id : delete the "id" personVital.
	 *
	 * @param id
	 *            the id of the personVitalDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/person-vitals/{id}")
	@Timed
	public ResponseEntity<Void> deletePersonVital(@PathVariable String id) {
		log.debug("REST request to delete PersonVital : {}", id);
		personVitalService.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}

	@GetMapping("/people/{personId}/person-vitals/{vitalId}")
	@Timed
	public ResponseEntity<PersonVitalDTO> getByDateAndPersonIdPersonVital(@PathVariable String personId,@PathVariable Long vitalId,
			@RequestParam(required = false, value = "date", defaultValue = "") LocalDateTime date) {
		PersonVitalDTO personVitalDTO = personVitalService.findByVitalIdAndPersonIdAndDate(personId, vitalId, date);
		return ResponseUtil.wrapOrNotFound(Optional.ofNullable(personVitalDTO));
	}
	
}
