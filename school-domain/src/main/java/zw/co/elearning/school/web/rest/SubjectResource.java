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
import zw.co.elearning.school.service.SubjectService;
import zw.co.elearning.school.service.dto.SubjectDTO;
import zw.co.elearning.school.web.rest.util.HeaderUtil;
import zw.co.elearning.school.web.rest.util.PaginationUtil;
/**
 * REST controller for managing subject.
 */
@RestController
@RequestMapping("/api")
public class SubjectResource {

	private final Logger log = LoggerFactory.getLogger(SubjectResource.class);

	private static final String ENTITY_NAME = "subject";

	private final SubjectService subjectService;

	public SubjectResource(SubjectService subjectService) {
		super();
		this.subjectService = subjectService;
	}

	/**
	 * POST /subjects : Create a new subject.
	 *
	 * @param subjectDTO
	 *            the subjectDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new subjectDTO, or with status 400 (Bad Request) if the subject
	 *         has already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/subjects")
	@Timed
	public ResponseEntity<SubjectDTO> createsubject(@Valid @RequestBody SubjectDTO subjectDTO)
			throws URISyntaxException {
		log.debug("REST request to save subject : {}", subjectDTO);
		if (subjectDTO.getId() != null) {
			return ResponseEntity.badRequest().headers(
					HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new subject cannot already have an ID"))
					.body(null);
		}
		SubjectDTO result = subjectService.save(subjectDTO);
		return ResponseEntity.created(new URI("/api/subjects/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /subjects : Updates an existing subject.
	 *
	 * @param subjectDTO
	 *            the subjectDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         subjectDTO, or with status 400 (Bad Request) if the subjectDTO is
	 *         not valid, or with status 500 (Internal Server Error) if the
	 *         subjectDTO couldnt be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/subjects")
	@Timed
	public ResponseEntity<SubjectDTO> updatesubject(@Valid @RequestBody SubjectDTO subjectDTO)
			throws URISyntaxException {
		log.debug("REST request to update subject : {}", subjectDTO);
		if (subjectDTO.getId() == null) {
			return createsubject(subjectDTO);
		}
		SubjectDTO result = subjectService.save(subjectDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, subjectDTO.getId().toString())).body(result);
	}

	/**
	 * GET /subjects : get all the subjects.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of subjects
	 *         in body
	 * @throws URISyntaxException
	 *             if there is an error to generate the pagination HTTP headers
	 */
	@GetMapping("/subjects")
	@Timed
	public ResponseEntity<List<SubjectDTO>> getAllsubjects(@ApiParam Pageable pageable) throws URISyntaxException {
		log.debug("REST request to get all subjects");
        Page<SubjectDTO> page = subjectService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/subjects");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	@GetMapping("/subjects/subjects")
	@Timed
	public ResponseEntity<List<SubjectDTO>> getByIds(@RequestParam(value = "subjectId", required = true) String[] ids)
			throws URISyntaxException {
		log.debug("REST request to get a page of subjects");
		List<SubjectDTO> result = subjectService.findByIds(ids);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * GET /subjects/:id : get the "id" subject.
	 *
	 * @param id
	 *            the id of the subjectDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         subjectDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/subjects/{id}")
	@Timed
	public ResponseEntity<SubjectDTO> getsubject(@PathVariable String id) {
		log.debug("REST request to get subject : {}", id);
		SubjectDTO subjectDTO = subjectService.findOne(id);
		return ResponseUtil.wrapOrNotFound(Optional.ofNullable(subjectDTO));
	}

	/**
	 * DELETE /subjects/:id : delete the "id" subject.
	 *
	 * @param id
	 *            the id of the subjectDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/subjects/{id}")
	@Timed
	public ResponseEntity<Void> deletesubject(@PathVariable String id) {
		log.debug("REST request to delete subject : {}", id);
		subjectService.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}

}
