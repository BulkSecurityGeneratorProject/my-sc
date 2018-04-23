package zw.co.elearning.school.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zw.co.elearning.school.domain.Person;
import zw.co.elearning.school.repository.PersonRepository;
import zw.co.elearning.school.service.PersonService;
import zw.co.elearning.school.service.dto.PersonDTO;
import zw.co.elearning.school.service.mapper.PersonMapper;

/**
 * Service Implementation for managing Person.
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	private final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

	private final PersonRepository personRepository;

	private final PersonMapper personMapper;

	public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
		this.personRepository = personRepository;
		this.personMapper = personMapper;

	}

	/**
	 * Save a person.
	 *
	 * @param personDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public PersonDTO save(PersonDTO personDTO) {
		log.debug("Request to save Person : {}", personDTO);
		Person person = personMapper.personDTOToPerson(personDTO);
		person = personRepository.save(person);
		PersonDTO result = personMapper.personToPersonDTO(person);
		return result;
	}

	/**
	 * Get all the people.
	 * 
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<PersonDTO> findAll(String text, Pageable pageable) {
		log.debug("Request to get all People");

		Page<Person> result = null;

		result = personRepository.findByLastnameContainingOrFirstnameContainingAllIgnoringCase(text, text, pageable);

		return result.map(person -> personMapper.personToPersonDTO(person));
	}

	/**
	 * Get one person by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	@Transactional(readOnly = true)
	public PersonDTO findOne(String id) {
		log.debug("Request to get Person : {}", id);
		Person person = personRepository.findOne(id);
		PersonDTO personDTO = personMapper.personToPersonDTO(person);
		return personDTO;
	}

	/**
	 * Delete the person by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(String id) {
		log.debug("Request to delete Person : {}", id);
		personRepository.delete(id);
	}

	@Override
	public List<PersonDTO> getPeopleByClass(String classNameId) {
		log.debug("Request to get all People");

		List<Person> result = null;

		result = personRepository.findByClassNameId(classNameId);

		return personMapper.peopleToPersonDTOs(result);
	}

}
