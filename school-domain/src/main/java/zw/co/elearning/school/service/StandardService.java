package zw.co.elearning.school.service;

import zw.co.elearning.school.service.dto.StandardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing Standard.
 */
public interface StandardService {

    /**
     * Save a standard.
     *
     * @param standardDTO the entity to save
     * @return the persisted entity
     */
    StandardDTO save(StandardDTO standardDTO);

    /**
     *  Get all the standards.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<StandardDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" standard.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    StandardDTO findOne(String id);

    /**
     *  Delete the "id" standard.
     *
     *  @param id the id of the entity
     */
    void delete(String id);
}
