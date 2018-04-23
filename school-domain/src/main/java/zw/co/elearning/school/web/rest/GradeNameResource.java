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
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.ApiParam;
import zw.co.elearning.school.service.GradeNameService;
import zw.co.elearning.school.service.dto.GradeNameDTO;
import zw.co.elearning.school.web.rest.util.HeaderUtil;
import zw.co.elearning.school.web.rest.util.PaginationUtil;

/**
 * REST controller for managing GradeName.
 */
@RestController
@RequestMapping("/api")
public class GradeNameResource {

	private final Logger log = LoggerFactory.getLogger(GradeNameResource.class);

	private static final String ENTITY_NAME = "gradeName";

	private final GradeNameService gradeNameService;

	public GradeNameResource(GradeNameService gradeNameService) {
		this.gradeNameService = gradeNameService;
	}

	/**
	 * POST /gradeName : Create a new gradeName.
	 *
	 * @param gradeNameDTO
	 *            the gradeNameDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new gradeNameDTO, or with status 400 (Bad Request) if the
	 *         gradeName has already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/gradeName")
	@Timed
	public ResponseEntity<GradeNameDTO> createGradeName(@Valid @RequestBody GradeNameDTO gradeNameDTO)
			throws URISyntaxException {
		log.debug("REST request to save GradeName : {}", gradeNameDTO);
		if (gradeNameDTO.getId() != null) {
			return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists",
					"A new gradeName cannot already have an ID")).body(null);
		}
		GradeNameDTO result = gradeNameService.save(gradeNameDTO);
		return ResponseEntity.created(new URI("/api/gradeName/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /gradeName : Updates an existing gradeName.
	 *
	 * @param gradeNameDTO
	 *            the gradeNameDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         gradeNameDTO, or with status 400 (Bad Request) if the
	 *         gradeNameDTO is not valid, or with status 500 (Internal Server
	 *         Error) if the gradeNameDTO couldnt be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/gradeName")
	@Timed
	public ResponseEntity<GradeNameDTO> updateGradeName(@Valid @RequestBody GradeNameDTO gradeNameDTO)
			throws URISyntaxException {
		log.debug("REST request to update GradeName : {}", gradeNameDTO);
		if (gradeNameDTO.getId() == null) {
			return createGradeName(gradeNameDTO);
		}
		GradeNameDTO result = gradeNameService.save(gradeNameDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, gradeNameDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /gradeName : get all the gradeNames.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of
	 *         gradeNames in body
	 * @throws URISyntaxException
	 *             if there is an error to generate the pagination HTTP headers
	 */
	@GetMapping("/gradeName")
	@Timed
	public ResponseEntity<List<GradeNameDTO>> getAllGradeNames(@ApiParam Pageable pageable)
			throws URISyntaxException {
		log.debug("REST request to get a page of GradeNames");
		Page<GradeNameDTO> page = gradeNameService.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/gradeName");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /gradeName/:id : get the "id" gradeName.
	 *
	 * @param id
	 *            the id of the gradeNameDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         gradeNameDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/gradeName/{id}")
	@Timed
	public ResponseEntity<GradeNameDTO> getGradeName(@PathVariable String id) {
		log.debug("REST request to get GradeName : {}", id);
		GradeNameDTO gradeNameDTO = gradeNameService.findOne(id);
		return ResponseUtil.wrapOrNotFound(Optional.ofNullable(gradeNameDTO));
	}

	/**
	 * DELETE /gradeName/:id : delete the "id" gradeName.
	 *
	 * @param id
	 *            the id of the gradeNameDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/gradeName/{id}")
	@Timed
	public ResponseEntity<Void> deleteGradeName(@PathVariable String id) {
		log.debug("REST request to delete GradeName : {}", id);
		gradeNameService.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}

	
}
