package zw.co.elearning.school.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
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
import zw.co.elearning.school.service.PersonService;
import zw.co.elearning.school.service.dto.PersonDTO;
import zw.co.elearning.school.web.rest.util.HeaderUtil;
import zw.co.elearning.school.web.rest.util.PaginationUtil;

/**
 * REST controller for managing Person.
 */
@RestController
@RequestMapping("/api")
public class PersonResource {

	private final Logger log = LoggerFactory.getLogger(PersonResource.class);

	private static final String ENTITY_NAME = "person";

	private final PersonService personService;



	public PersonResource(PersonService personService) {
		this.personService = personService;
	}

	/**
	 * POST /people : Create a new person.
	 *
	 * @param personDTO
	 *            the personDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new personDTO, or with status 400 (Bad Request) if the person has
	 *         already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/people")
	@Timed
	public ResponseEntity<PersonDTO> createPerson(@Valid @RequestBody PersonDTO personDTO) throws URISyntaxException {
		log.debug("REST request to save Person : {}", personDTO);
		if (personDTO.getId() != null) {
			return ResponseEntity.badRequest().headers(
					HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new person cannot already have an ID"))
					.body(null);
		}
		PersonDTO result = personService.save(personDTO);
		return ResponseEntity.created(new URI("/api/people/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /people : Updates an existing person.
	 *
	 * @param personDTO
	 *            the personDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         personDTO, or with status 400 (Bad Request) if the personDTO is
	 *         not valid, or with status 500 (Internal Server Error) if the
	 *         personDTO couldnt be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/people")
	@Timed
	public ResponseEntity<PersonDTO> updatePerson(@Valid @RequestBody PersonDTO personDTO) throws URISyntaxException {
		log.debug("REST request to update Person : {}", personDTO);
		if (personDTO.getId() == null) {
			return createPerson(personDTO);
		}
		PersonDTO result = personService.save(personDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, personDTO.getId().toString())).body(result);
	}

	/**
	 * GET /people : get all the people.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of people in
	 *         body
	 * @throws URISyntaxException
	 *             if there is an error to generate the pagination HTTP headers
	 */
	@GetMapping("/people")
	@Timed
	public ResponseEntity<Page<PersonDTO>> getPeople(
			@RequestParam(value = "text", required = false, defaultValue = "") String text, @ApiParam Pageable pageable)
			throws URISyntaxException {
		log.debug("REST request to get a page of People");
		Page<PersonDTO> page = personService.findAll(text, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/people");
		return new ResponseEntity<>(page, headers, HttpStatus.OK);
	}

	

	/**
	 * GET /people/:id : get the "id" person.
	 *
	 * @param id
	 *            the id of the personDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         personDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/people/{id}")
	@Timed
	public ResponseEntity<PersonDTO> getPerson(@PathVariable String id) {
		log.debug("REST request to get Person : {}", id);
		PersonDTO personDTO = personService.findOne(id);
		return ResponseUtil.wrapOrNotFound(Optional.ofNullable(personDTO));
	}

	/**
	 * DELETE /people/:id : delete the "id" person.
	 *
	 * @param id
	 *            the id of the personDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/people/{id}")
	@Timed
	public ResponseEntity<Void> deletePerson(@PathVariable String id) {
		log.debug("REST request to delete Person : {}", id);
		personService.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
	
	
	/**
	 * GET /people : get people by class.
	 *
	 * @return the ResponseEntity with status 200 (OK) and the list of people in
	 *         body
	 * @throws URISyntaxException
	 *             if there is an error to generate the pagination HTTP headers
	 */
	@GetMapping("/people/{classNameId}/class-name")
	@Timed
	public List<PersonDTO> getPeopleByClass(@PathVariable String classNameId)
			throws URISyntaxException {
		log.debug("REST request to get People by class");
		List<PersonDTO> result = personService.getPeopleByClass(classNameId);
		return result;
	}


	

	
}
