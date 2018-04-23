package zw.co.elearning.school.service;

import zw.co.elearning.school.service.dto.AllergyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing Allergy.
 */
public interface AllergyService {

    /**
     * Save a allergy.
     *
     * @param allergyDTO the entity to save
     * @return the persisted entity
     */
    AllergyDTO save(AllergyDTO allergyDTO);

    /**
     *  Get all the allergies.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<AllergyDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" allergy.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    AllergyDTO findOne(String id);

    /**
     *  Delete the "id" allergy.
     *
     *  @param id the id of the entity
     */
    void delete(String id);
}
