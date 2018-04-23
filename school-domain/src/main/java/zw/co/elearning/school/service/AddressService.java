package zw.co.elearning.school.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import zw.co.elearning.school.service.dto.AddressDTO;

import java.util.List;
import java.util.Map;

/**
 * Service Interface for managing Address.
 */
public interface AddressService {

    /**
     * Save a address.
     *
     * @param addressDTO the entity to save
     * @return the persisted entity
     */
    AddressDTO save(AddressDTO addressDTO);

    /**
     *  Get all the addresses.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<AddressDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" address.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    AddressDTO findOne(String id);

    /**
     *  Delete the "id" address.
     *
     *  @param id the id of the entity
     */
    void delete(String id);

    List<Map<String, Object>> findByPersonId(String personId);
}
