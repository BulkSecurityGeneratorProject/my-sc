package zw.co.elearning.school.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import zw.co.elearning.school.service.dto.ClassNameDTO;

/**
 * Service Interface for managing ClassName.
 */
public interface ClassNameService {

    /**
     * Save a className.
     *
     * @param classNameDTO the entity to save
     * @return the persisted entity
     */
    ClassNameDTO save(ClassNameDTO classNameDTO);

    /**
     *  Get all the people.
     * @param text 
     *  
     *  @param pageable the pagination information
     *  @return the list of entities	
     */
    Page<ClassNameDTO> findAll(String text, Pageable pageable);

    /**
     *  Get the "id" className.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    ClassNameDTO findOne(String id);

    /**
     *  Delete the "id" className.
     *
     *  @param id the id of the entity
     */
    void delete(String id);

	

}
