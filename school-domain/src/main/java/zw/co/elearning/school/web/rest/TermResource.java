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
import zw.co.elearning.school.service.TermService;
import zw.co.elearning.school.service.dto.TermDTO;
import zw.co.elearning.school.web.rest.util.HeaderUtil;
import zw.co.elearning.school.web.rest.util.PaginationUtil;

/**
 * REST controller for managing Term.
 */
@RestController
@RequestMapping("/api")
public class TermResource {

	private final Logger log = LoggerFactory.getLogger(TermResource.class);

	private static final String ENTITY_NAME = "term";

	private final TermService termService;

	public TermResource(TermService termService) {
		this.termService = termService;
	}

	/**
	 * POST /term : Create a new term.
	 *
	 * @param termDTO
	 *            the termDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new termDTO, or with status 400 (Bad Request) if the
	 *         term has already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/term")
	@Timed
	public ResponseEntity<TermDTO> createTerm(@Valid @RequestBody TermDTO termDTO)
			throws URISyntaxException {
		log.debug("REST request to save Term : {}", termDTO);
		if (termDTO.getId() != null) {
			return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists",
					"A new term cannot already have an ID")).body(null);
		}
		TermDTO result = termService.save(termDTO);
		return ResponseEntity.created(new URI("/api/term/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /term : Updates an existing term.
	 *
	 * @param termDTO
	 *            the termDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         termDTO, or with status 400 (Bad Request) if the
	 *         termDTO is not valid, or with status 500 (Internal Server
	 *         Error) if the termDTO couldnt be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/term")
	@Timed
	public ResponseEntity<TermDTO> updateTerm(@Valid @RequestBody TermDTO termDTO)
			throws URISyntaxException {
		log.debug("REST request to update Term : {}", termDTO);
		if (termDTO.getId() == null) {
			return createTerm(termDTO);
		}
		TermDTO result = termService.save(termDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, termDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /term : get all the terms.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of
	 *         terms in body
	 * @throws URISyntaxException
	 *             if there is an error to generate the pagination HTTP headers
	 */
	@GetMapping("/term")
	@Timed
	public ResponseEntity<List<TermDTO>> getAllTerms(@ApiParam Pageable pageable)
			throws URISyntaxException {
		log.debug("REST request to get a page of Terms");
		Page<TermDTO> page = termService.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/term");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /term/:id : get the "id" term.
	 *
	 * @param id
	 *            the id of the termDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         termDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/term/{id}")
	@Timed
	public ResponseEntity<TermDTO> getTerm(@PathVariable String id) {
		log.debug("REST request to get Term : {}", id);
		TermDTO termDTO = termService.findOne(id);
		return ResponseUtil.wrapOrNotFound(Optional.ofNullable(termDTO));
	}

	/**
	 * DELETE /term/:id : delete the "id" term.
	 *
	 * @param id
	 *            the id of the termDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/term/{id}")
	@Timed
	public ResponseEntity<Void> deleteTerm(@PathVariable String id) {
		log.debug("REST request to delete Term : {}", id);
		termService.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}

	
}
