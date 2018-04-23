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
import zw.co.elearning.school.service.PersonResultService;
import zw.co.elearning.school.service.dto.PersonResultDTO;
import zw.co.elearning.school.web.rest.util.HeaderUtil;
import zw.co.elearning.school.web.rest.util.PaginationUtil;

/**
 * REST controller for managing PersonResult.
 */
@RestController
@RequestMapping("/api")
public class PersonResultResource {

	private final Logger log = LoggerFactory.getLogger(PersonResultResource.class);

	private static final String ENTITY_NAME = "personResult";
	private final PersonResultService personResultService;

	public PersonResultResource(PersonResultService personResultService) {
		this.personResultService = personResultService;
	}

	/**
	 * POST /personResults : Create a new personResult.
	 *
	 * @param personResultDTO
	 *            the personResultDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new personResultDTO, or with status 400 (Bad Request) if the
	 *         personResult has already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/personResults")
	@Timed
	public void createPersonResult(@Valid @RequestBody List<PersonResultDTO> personResultDTO)
			throws URISyntaxException {
		log.debug("REST request to save PersonResults : {}", personResultDTO);

		personResultService.saveMultiple(personResultDTO);

	}

	/**
	 * PUT /personResults : Updates an existing personResult.
	 *
	 * @param personResultDTO
	 *            the personResultDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         personResultDTO, or with status 400 (Bad Request) if the
	 *         personResultDTO is not valid, or with status 500 (Internal Server
	 *         Error) if the personResultDTO couldnt be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/personResults")
	@Timed
	public PersonResultDTO updatePersonResult(@Valid @RequestBody PersonResultDTO personResultDTO)
			throws URISyntaxException {
		log.debug("REST request to update PersonResult : {}", personResultDTO);

		return personResultService.save(personResultDTO);

	}

	/**
	 * GET /personResults : get all the personResults.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of
	 *         personResults in body
	 * @throws URISyntaxException
	 *             if there is an error to generate the pagination HTTP headers
	 */
	@GetMapping("/personResults/subject-activity/{subjectActivityId}/term/{termId}/class-name-id/{classNameId}/results")
	@Timed
	public ResponseEntity<List<PersonResultDTO>> getResultsBySubjectActivityIdTermIdClassNameId(@PathVariable String termId, @PathVariable String classNameId, @PathVariable String subjectActivityId)
					throws URISyntaxException {
		log.debug("REST request to get a page of PersonResults");
		List<PersonResultDTO> page = personResultService.findByTermIdAndclassNameIdAndSubjectActivityId(termId,
				classNameId, subjectActivityId);
		return new ResponseEntity<>(page, HttpStatus.OK);
	}

	/**
	 * GET /personResults/:id : get the "id" personResult.
	 *
	 * @param id
	 *            the id of the personResultDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         personResultDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/personResults/{id}")
	@Timed
	public ResponseEntity<PersonResultDTO> getPersonResult(@PathVariable String id) {
		log.debug("REST request to get PersonResult : {}", id);
		PersonResultDTO personResultDTO = personResultService.findOne(id);
		return ResponseUtil.wrapOrNotFound(Optional.ofNullable(personResultDTO));
	}
	
	

	/**
	 * DELETE /personResults/:id : delete the "id" personResult.
	 *
	 * @param id
	 *            the id of the personResultDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/personResults/{id}")
	@Timed
	public ResponseEntity<Void> deletePersonResult(@PathVariable String id) {
		log.debug("REST request to delete PersonResult : {}", id);
		personResultService.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}

}
