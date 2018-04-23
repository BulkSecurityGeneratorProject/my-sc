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
import zw.co.elearning.school.service.ClassNameService;
import zw.co.elearning.school.service.dto.ClassNameDTO;
import zw.co.elearning.school.web.rest.util.HeaderUtil;
import zw.co.elearning.school.web.rest.util.PaginationUtil;

/**
 * REST controller for managing ClassName.
 */
@RestController
@RequestMapping("/api")
public class ClassNameResource {

	private final Logger log = LoggerFactory.getLogger(ClassNameResource.class);

	private static final String ENTITY_NAME = "className";

	private final ClassNameService classNameService;



	public ClassNameResource(ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * POST /people : Create a new className.
	 *
	 * @param classNameDTO
	 *            the classNameDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new classNameDTO, or with status 400 (Bad Request) if the className has
	 *         already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/class-name")
	@Timed
	public ResponseEntity<ClassNameDTO> createClassName(@Valid @RequestBody ClassNameDTO classNameDTO) throws URISyntaxException {
		log.debug("REST request to save ClassName : {}", classNameDTO);
		if (classNameDTO.getId() != null) {
			return ResponseEntity.badRequest().headers(
					HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new className cannot already have an ID"))
					.body(null);
		}
		ClassNameDTO result = classNameService.save(classNameDTO);
		return ResponseEntity.created(new URI("/api/people/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /people : Updates an existing className.
	 *
	 * @param classNameDTO
	 *            the classNameDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         classNameDTO, or with status 400 (Bad Request) if the classNameDTO is
	 *         not valid, or with status 500 (Internal Server Error) if the
	 *         classNameDTO couldnt be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/class-name")
	@Timed
	public ResponseEntity<ClassNameDTO> updateClassName(@Valid @RequestBody ClassNameDTO classNameDTO) throws URISyntaxException {
		log.debug("REST request to update ClassName : {}", classNameDTO);
		if (classNameDTO.getId() == null) {
			return createClassName(classNameDTO);
		}
		ClassNameDTO result = classNameService.save(classNameDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, classNameDTO.getId().toString())).body(result);
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
	@GetMapping("/class-name")
	@Timed
	public ResponseEntity<Page<ClassNameDTO>> getPeople(
			@RequestParam(value = "text", required = false, defaultValue = "") String text, @ApiParam Pageable pageable)
			throws URISyntaxException {
		log.debug("REST request to get a page of People");
		Page<ClassNameDTO> page = classNameService.findAll(text, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/people");
		return new ResponseEntity<>(page, headers, HttpStatus.OK);
	}

	

	/**
	 * GET /people/:id : get the "id" className.
	 *
	 * @param id
	 *            the id of the classNameDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         classNameDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/class-name/{id}")
	@Timed
	public ResponseEntity<ClassNameDTO> getClassName(@PathVariable String id) {
		log.debug("REST request to get ClassName : {}", id);
		ClassNameDTO classNameDTO = classNameService.findOne(id);
		return ResponseUtil.wrapOrNotFound(Optional.ofNullable(classNameDTO));
	}

	/**
	 * DELETE /people/:id : delete the "id" className.
	 *
	 * @param id
	 *            the id of the classNameDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/class-name/{id}")
	@Timed
	public ResponseEntity<Void> deleteClassName(@PathVariable String id) {
		log.debug("REST request to delete ClassName : {}", id);
		classNameService.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
	
	
	


	

	
}
