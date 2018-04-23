package zw.co.elearning.school.service.impl;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zw.co.elearning.school.domain.PersonResult;
import zw.co.elearning.school.repository.PersonResultRepository;
import zw.co.elearning.school.service.PersonResultService;
import zw.co.elearning.school.service.dto.PersonResultDTO;
import zw.co.elearning.school.service.mapper.PersonResultMapper;

/**
 * Service Implementation for managing PersonResult.
 */
@Service
@Transactional
public class PersonResultServiceImpl implements PersonResultService {

	private final Logger log = LoggerFactory.getLogger(PersonResultServiceImpl.class);

	private final PersonResultRepository personResultRepository;
	
	private final PersonResultMapper personResultMapper;

	

	public PersonResultServiceImpl(PersonResultRepository personResultRepository, PersonResultMapper personResultMapper) {
		this.personResultRepository = personResultRepository;
		this.personResultMapper = personResultMapper;
	}

	/**
	 * Save a personResult.
	 *
	 * @param personResultDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public PersonResultDTO save(PersonResultDTO personResultDTO) {
		log.debug("Request to save PersonResult : {}", personResultDTO);
		PersonResult personResult = personResultMapper.personResultDTOToPersonResult(personResultDTO);
		personResult = personResultRepository.save(personResult);
		PersonResultDTO result = personResultMapper.personResultToPersonResultDTO(personResult);
		return result;
	}

	
	/**
	 * Get one personResult by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	@Transactional(readOnly = true)
	public PersonResultDTO findOne(String id) {
		log.debug("Request to get PersonResult : {}", id);
		PersonResult personResult = personResultRepository.findOne(id);
		PersonResultDTO personResultDTO = personResultMapper.personResultToPersonResultDTO(personResult);
		return personResultDTO;
	}

	/**
	 * Delete the personResult by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(String id) {
		log.debug("Request to delete PersonResult : {}", id);
		personResultRepository.delete(id);
	}

	@Override
	public List<PersonResultDTO> findByTermIdAndclassNameIdAndSubjectActivityId(String termId, String classNameId,
			String SubjectActivityID) {
		return personResultMapper
				.personResultsToPersonResultDTOs(personResultRepository.findByTermIdAndClassNameIdAndSubjectActivityId(termId,classNameId, SubjectActivityID));
	}

	@Override
	public void saveMultiple(List<PersonResultDTO> personResultDTO) {
		log.debug("Request to save PersonResults : {}", personResultDTO);
		
		for(PersonResultDTO result: personResultDTO){
			log.debug("Request to save in save : {}", personResultDTO);
			PersonResult personResult = personResultMapper.personResultDTOToPersonResult(result);
			personResult = personResultRepository.save(personResult);
		}
	
		
	}
	
	

	
}
