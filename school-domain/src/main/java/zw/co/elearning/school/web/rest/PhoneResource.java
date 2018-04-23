package zw.co.elearning.school.web.rest;

import com.codahale.metrics.annotation.Timed;

import zw.co.elearning.school.service.PhoneService;
import zw.co.elearning.school.service.dto.PhoneDTO;
import zw.co.elearning.school.web.rest.util.HeaderUtil;
import zw.co.elearning.school.web.rest.util.PaginationUtil;
import io.swagger.annotations.ApiParam;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing Phone.
 */
@RestController
@RequestMapping("/api")
public class PhoneResource {

	private final Logger log = LoggerFactory.getLogger(PhoneResource.class);

	private static final String ENTITY_NAME = "phone";

	private final PhoneService phoneService;

	public PhoneResource(PhoneService phoneService) {
		this.phoneService = phoneService;
	}

	/**
	 * POST /phones : Create a new phone.
	 *
	 * @param phoneDTO
	 *            the phoneDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new phoneDTO, or with status 400 (Bad Request) if the phone has
	 *         already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/phones")
	@Timed
	public ResponseEntity<PhoneDTO> createPhone(@Valid @RequestBody PhoneDTO phoneDTO) throws URISyntaxException {
		log.debug("REST request to save Phone : {}", phoneDTO);
		if (phoneDTO.getId() != null) {
			return ResponseEntity.badRequest().headers(
					HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new phone cannot already have an ID"))
					.body(null);
		}
		PhoneDTO result = phoneService.save(phoneDTO);
		return ResponseEntity.created(new URI("/api/phones/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /phones : Updates an existing phone.
	 *
	 * @param phoneDTO
	 *            the phoneDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         phoneDTO, or with status 400 (Bad Request) if the phoneDTO is not
	 *         valid, or with status 500 (Internal Server Error) if the phoneDTO
	 *         couldnt be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/phones")
	@Timed
	public ResponseEntity<PhoneDTO> updatePhone(@Valid @RequestBody PhoneDTO phoneDTO) throws URISyntaxException {
		log.debug("REST request to update Phone : {}", phoneDTO);
		if (phoneDTO.getId() == null) {
			return createPhone(phoneDTO);
		}
		PhoneDTO result = phoneService.save(phoneDTO);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, phoneDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /phones : get all the phones.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of phones in
	 *         body
	 * @throws URISyntaxException
	 *             if there is an error to generate the pagination HTTP headers
	 */

	@GetMapping("/phones/people/{personId}")
	@Timed
	public ResponseEntity<List<PhoneDTO>> getPhonesByPersonId(@PathVariable String personId) throws URISyntaxException {
		log.debug("REST request to get a page of Phones");
		List<PhoneDTO> result = phoneService.findByPersonId(personId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}


	/**
	 * GET /phones/:id : get the "id" phone.
	 *
	 * @param id
	 *            the id of the phoneDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         phoneDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/phones/{id}")
	@Timed
	public ResponseEntity<PhoneDTO> getPhone(@PathVariable String id) {
		log.debug("REST request to get Phone : {}", id);
		PhoneDTO phoneDTO = phoneService.findOne(id);
		return ResponseUtil.wrapOrNotFound(Optional.ofNullable(phoneDTO));
	}

	/**
	 * DELETE /phones/:id : delete the "id" phone.
	 *
	 * @param id
	 *            the id of the phoneDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/phones/{id}")
	@Timed
	public ResponseEntity<Void> deletePhone(@PathVariable String id) {
		log.debug("REST request to delete Phone : {}", id);
		phoneService.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}

}
