package zw.co.elearning.school.web.rest;

import com.codahale.metrics.annotation.Timed;

import zw.co.elearning.school.service.EmailService;
import zw.co.elearning.school.service.dto.AddressDTO;
import zw.co.elearning.school.service.dto.EmailDTO;
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
 * REST controller for managing Email.
 */
@RestController
@RequestMapping("/api")
public class EmailResource {

	private final Logger log = LoggerFactory.getLogger(EmailResource.class);

	private static final String ENTITY_NAME = "email";

	private final EmailService emailService;

	public EmailResource(EmailService emailService) {
		this.emailService = emailService;
	}

	/**
	 * POST /emails : Create a new email.
	 *
	 * @param emailDTO
	 *            the emailDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new emailDTO, or with status 400 (Bad Request) if the email has
	 *         already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/emails")
	@Timed
	public ResponseEntity<EmailDTO> createEmail(@Valid @RequestBody EmailDTO emailDTO) throws URISyntaxException {
		log.debug("REST request to save Email : {}", emailDTO);
		if (emailDTO.getId() != null) {
			return ResponseEntity.badRequest().headers(
					HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new email cannot already have an ID"))
					.body(null);
		}
		EmailDTO result = emailService.save(emailDTO);
		return ResponseEntity.created(new URI("/api/emails/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /emails : Updates an existing email.
	 *
	 * @param emailDTO
	 *            the emailDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         emailDTO, or with status 400 (Bad Request) if the emailDTO is not
	 *         valid, or with status 500 (Internal Server Error) if the emailDTO
	 *         couldnt be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/emails")
	@Timed
	public ResponseEntity<EmailDTO> updateEmail(@Valid @RequestBody EmailDTO emailDTO) throws URISyntaxException {
		log.debug("REST request to update Email : {}", emailDTO);
		if (emailDTO.getId() == null) {
			return createEmail(emailDTO);
		}
		EmailDTO result = emailService.save(emailDTO);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emailDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /emails : get all the emails.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of emails in
	 *         body
	 * @throws URISyntaxException
	 *             if there is an error to generate the pagination HTTP headers
	 */
	@GetMapping("/emails/people/{personId}")
	@Timed
	public ResponseEntity<List<EmailDTO>> getEmailsByPersonId(@PathVariable String personId) throws URISyntaxException {
		log.debug("REST request to get a page of Emails");
		List<EmailDTO> result = emailService.findByPersonId(personId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * GET /emails/:id : get the "id" email.
	 *
	 * @param id
	 *            the id of the emailDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         emailDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/emails/{id}")
	@Timed
	public ResponseEntity<EmailDTO> getEmail(@PathVariable String id) {
		log.debug("REST request to get Email : {}", id);
		EmailDTO emailDTO = emailService.findOne(id);
		return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emailDTO));
	}

	/**
	 * DELETE /emails/:id : delete the "id" email.
	 *
	 * @param id
	 *            the id of the emailDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/emails/{id}")
	@Timed
	public ResponseEntity<Void> deleteEmail(@PathVariable String id) {
		log.debug("REST request to delete Email : {}", id);
		emailService.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}

}
