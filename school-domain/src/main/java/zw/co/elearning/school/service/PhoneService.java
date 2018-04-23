package zw.co.elearning.school.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import zw.co.elearning.school.service.dto.PhoneDTO;

import java.util.List;

/**
 * Service Interface for managing Phone.
 */
public interface PhoneService {

    /**
     * Save a phone.
     *
     * @param phoneDTO the entity to save
     * @return the persisted entity
     */
    PhoneDTO save(PhoneDTO phoneDTO);

    /**
     *  Get all the phones.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<PhoneDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" phone.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PhoneDTO findOne(String id);

    /**
     *  Delete the "id" phone.
     *
     *  @param id the id of the entity
     */
    void delete(String id);


	List<PhoneDTO> findByPersonId(String personId);
}
