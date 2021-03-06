package zw.co.elearning.school.service;

import zw.co.elearning.school.service.dto.UnitDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing Unit.
 */
public interface UnitService {

    /**
     * Save a unit.
     *
     * @param unitDTO the entity to save
     * @return the persisted entity
     */
    UnitDTO save(UnitDTO unitDTO);

    /**
     *  Get all the units.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<UnitDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" unit.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    UnitDTO findOne(String id);

    /**
     *  Delete the "id" unit.
     *
     *  @param id the id of the entity
     */
    void delete(String id);
}
