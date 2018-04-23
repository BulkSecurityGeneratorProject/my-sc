package zw.co.elearning.school.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zw.co.elearning.school.domain.Email;
import zw.co.elearning.school.repository.EmailRepository;
import zw.co.elearning.school.service.EmailService;
import zw.co.elearning.school.service.dto.EmailDTO;
import zw.co.elearning.school.service.mapper.EmailMapper;

/**
 * Service Implementation for managing Email.
 */
@Service
@Transactional
public class EmailServiceImpl implements EmailService {

	private final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

	private final EmailRepository emailRepository;

	private final EmailMapper emailMapper;

	public EmailServiceImpl(EmailRepository emailRepository, EmailMapper emailMapper) {
		this.emailRepository = emailRepository;
		this.emailMapper = emailMapper;
	}

	/**
	 * Save a email.
	 *
	 * @param emailDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public EmailDTO save(EmailDTO emailDTO) {
		log.debug("Request to save Email : {}", emailDTO);
		Email email = emailMapper.emailDTOToEmail(emailDTO);
		email = emailRepository.save(email);
		EmailDTO result = emailMapper.emailToEmailDTO(email);
		return result;
	}

	/**
	 * Get all the emails.
	 * 
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<EmailDTO> findAll(Pageable pageable) {
		log.debug("Request to get all Emails");
		Page<Email> result = emailRepository.findAll(pageable);
		return result.map(email -> emailMapper.emailToEmailDTO(email));
	}

	/**
	 * Get one email by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	@Transactional(readOnly = true)
	public EmailDTO findOne(String id) {
		log.debug("Request to get Email : {}", id);
		Email email = emailRepository.findOne(id);
		EmailDTO emailDTO = emailMapper.emailToEmailDTO(email);
		return emailDTO;
	}

	/**
	 * Delete the email by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(String id) {
		log.debug("Request to delete Email : {}", id);
		emailRepository.delete(id);
	}

	@Override
	public List<EmailDTO> findByPersonId(String personId) {
		List<Email> result = emailRepository.findByPersonId(personId);
		return emailMapper.emailsToEmailDTOs(result);
	}
}
