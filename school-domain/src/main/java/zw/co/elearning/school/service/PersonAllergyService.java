package zw.co.elearning.school.service;

import java.util.List;

import zw.co.elearning.school.service.dto.PersonAllergyDTO;

/**
 * Service Interface for managing PersonAllergy.
 */
public interface PersonAllergyService {

    /**
     * Save a personAllergy.
     *
     * @param personAllergyDTO the entity to save
     * @return the persisted entity
     */
    PersonAllergyDTO save(PersonAllergyDTO personAllergyDTO);

    /**
     *  Get all the personAllergies.
     *  
     *  @return the list of entities
     */
    List<PersonAllergyDTO> findAll();

    /**
     *  Get the "id" personAllergy.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PersonAllergyDTO findOne(Long id);

    /**
     *  Delete the "id" personAllergy.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
