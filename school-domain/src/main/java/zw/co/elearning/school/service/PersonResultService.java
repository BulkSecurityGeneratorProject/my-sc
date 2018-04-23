package zw.co.elearning.school.service;

import java.util.Collection;
import java.util.List;

import zw.co.elearning.school.service.dto.PersonResultDTO;

/**
 * Service Interface for managing PersonResult.
 */
public interface PersonResultService {

	
	/**
	 *  
	 * Save a personResult.
	 *
	 * @param personResultDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	PersonResultDTO save(PersonResultDTO personResultDTO);



	/**
	 * Get the "id" personResult.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	PersonResultDTO findOne(String id);

	/**
	 * Delete the "id" personResult.
	 *
	 * @param id
	 *            the id of the entity
	 */
	void delete(String id);



	List<PersonResultDTO> findByTermIdAndclassNameIdAndSubjectActivityId(String termId, String classNameId, String SubjectActivityID);



	void saveMultiple(List<PersonResultDTO> personResultDTO);
	
	
}
