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
import zw.co.elearning.school.service.SubjectActivityService;
import zw.co.elearning.school.service.dto.SubjectActivityDTO;
import zw.co.elearning.school.web.rest.util.HeaderUtil;
import zw.co.elearning.school.web.rest.util.PaginationUtil;

/**
 * REST controller for managing SubjectActivity.
 */
@RestController
@RequestMapping("/api")
public class SubjectActivityResource {

	private final Logger log = LoggerFactory.getLogger(SubjectActivityResource.class);

	private static final String ENTITY_NAME = "subjectActivity";

	private final SubjectActivityService subjectActivityService;

	public SubjectActivityResource(SubjectActivityService subjectActivityService) {
		this.subjectActivityService = subjectActivityService;
	}

	/**
	 * POST /subjectActivity : Create a new subjectActivity.
	 *
	 * @param subjectActivityDTO
	 *            the subjectActivityDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new subjectActivityDTO, or with status 400 (Bad Request) if the
	 *         subjectActivity has already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/subjectActivity")
	@Timed
	public ResponseEntity<SubjectActivityDTO> createSubjectActivity(@Valid @RequestBody SubjectActivityDTO subjectActivityDTO)
			throws URISyntaxException {
		log.debug("REST request to save SubjectActivity : {}", subjectActivityDTO);
		if (subjectActivityDTO.getId() != null) {
			return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists",
					"A new subjectActivity cannot already have an ID")).body(null);
		}
		SubjectActivityDTO result = subjectActivityService.save(subjectActivityDTO);
		return ResponseEntity.created(new URI("/api/subjectActivity/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /subjectActivity : Updates an existing subjectActivity.
	 *
	 * @param subjectActivityDTO
	 *            the subjectActivityDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         subjectActivityDTO, or with status 400 (Bad Request) if the
	 *         subjectActivityDTO is not valid, or with status 500 (Internal Server
	 *         Error) if the subjectActivityDTO couldnt be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/subjectActivity")
	@Timed
	public ResponseEntity<SubjectActivityDTO> updateSubjectActivity(@Valid @RequestBody SubjectActivityDTO subjectActivityDTO)
			throws URISyntaxException {
		log.debug("REST request to update SubjectActivity : {}", subjectActivityDTO);
		if (subjectActivityDTO.getId() == null) {
			return createSubjectActivity(subjectActivityDTO);
		}
		SubjectActivityDTO result = subjectActivityService.save(subjectActivityDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, subjectActivityDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /subjectActivity : get all the subjectActivitys.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of
	 *         subjectActivitys in body
	 * @throws URISyntaxException
	 *             if there is an error to generate the pagination HTTP headers
	 */
	@GetMapping("/subjectActivity")
	@Timed
	public ResponseEntity<List<SubjectActivityDTO>> getAllSubjectActivitys(@ApiParam Pageable pageable)
			throws URISyntaxException {
		log.debug("REST request to get a page of SubjectActivitys");
		Page<SubjectActivityDTO> page = subjectActivityService.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/subjectActivity");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /subjectActivity/:id : get the "id" subjectActivity.
	 *
	 * @param id
	 *            the id of the subjectActivityDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         subjectActivityDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/subjectActivity/{id}")
	@Timed
	public ResponseEntity<SubjectActivityDTO> getSubjectActivity(@PathVariable String id) {
		log.debug("REST request to get SubjectActivity : {}", id);
		SubjectActivityDTO subjectActivityDTO = subjectActivityService.findOne(id);
		return ResponseUtil.wrapOrNotFound(Optional.ofNullable(subjectActivityDTO));
	}

	/**
	 * DELETE /subjectActivity/:id : delete the "id" subjectActivity.
	 *
	 * @param id
	 *            the id of the subjectActivityDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/subjectActivity/{id}")
	@Timed
	public ResponseEntity<Void> deleteSubjectActivity(@PathVariable String id) {
		log.debug("REST request to delete SubjectActivity : {}", id);
		subjectActivityService.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}

	
}
