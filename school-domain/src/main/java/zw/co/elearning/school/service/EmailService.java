package zw.co.elearning.school.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import zw.co.elearning.school.service.dto.EmailDTO;

import java.util.List;

/**
 * Service Interface for managing Email.
 */
public interface EmailService {

    /**
     * Save a email.
     *
     * @param emailDTO the entity to save
     * @return the persisted entity
     */
    EmailDTO save(EmailDTO emailDTO);

    /**
     *  Get all the emails.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<EmailDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" email.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    EmailDTO findOne(String id);

    /**
     *  Delete the "id" email.
     *
     *  @param id the id of the entity
     */
    void delete(String id);

	List<EmailDTO> findByPersonId(String personId);
}
