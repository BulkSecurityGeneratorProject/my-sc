package zw.co.elearning.school.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import zw.co.elearning.school.service.dto.PersonDTO;
import zw.co.elearning.school.service.dto.PersonIdDTO;

import java.util.List;

/**
 * Service Interface for managing Person.
 */
public interface PersonService {

    /**
     * Save a person.
     *
     * @param personDTO the entity to save
     * @return the persisted entity
     */
    PersonDTO save(PersonDTO personDTO);

    /**
     *  Get all the people.
     * @param text 
     *  
     *  @param pageable the pagination information
     *  @return the list of entities	
     */
    Page<PersonDTO> findAll(String text, Pageable pageable);

    /**
     *  Get the "id" person.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PersonDTO findOne(String id);

    /**
     *  Delete the "id" person.
     *
     *  @param id the id of the entity
     */
    void delete(String id);

	List<PersonDTO> getPeopleByClass(String classNameId);

}
