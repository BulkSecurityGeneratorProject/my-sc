package zw.co.elearning.school.service.impl;

import zw.co.elearning.school.domain.PersonAllergy;
import zw.co.elearning.school.repository.PersonAllergyRepository;
import zw.co.elearning.school.service.PersonAllergyService;
import zw.co.elearning.school.service.dto.PersonAllergyDTO;
import zw.co.elearning.school.service.mapper.PersonAllergyMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing PersonAllergy.
 */
@Service
@Transactional
public class PersonAllergyServiceImpl implements PersonAllergyService{

    private final Logger log = LoggerFactory.getLogger(PersonAllergyServiceImpl.class);
    
    private final PersonAllergyRepository personAllergyRepository;

    private final PersonAllergyMapper personAllergyMapper;

    public PersonAllergyServiceImpl(PersonAllergyRepository personAllergyRepository, PersonAllergyMapper personAllergyMapper) {
        this.personAllergyRepository = personAllergyRepository;
        this.personAllergyMapper = personAllergyMapper;
    }

    /**
     * Save a personAllergy.
     *
     * @param personAllergyDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PersonAllergyDTO save(PersonAllergyDTO personAllergyDTO) {
        log.debug("Request to save PersonAllergy : {}", personAllergyDTO);
        PersonAllergy personAllergy = personAllergyMapper.personAllergyDTOToPersonAllergy(personAllergyDTO);
        personAllergy = personAllergyRepository.save(personAllergy);
        PersonAllergyDTO result = personAllergyMapper.personAllergyToPersonAllergyDTO(personAllergy);
        return result;
    }

    /**
     *  Get all the personAllergies.
     *  
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<PersonAllergyDTO> findAll() {
        log.debug("Request to get all PersonAllergies");
        List<PersonAllergyDTO> result = personAllergyRepository.findAll().stream()
            .map(personAllergyMapper::personAllergyToPersonAllergyDTO)
            .collect(Collectors.toCollection(LinkedList::new));

        return result;
    }

    /**
     *  Get one personAllergy by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public PersonAllergyDTO findOne(Long id) {
        log.debug("Request to get PersonAllergy : {}", id);
        PersonAllergy personAllergy = personAllergyRepository.findOne(id);
        PersonAllergyDTO personAllergyDTO = personAllergyMapper.personAllergyToPersonAllergyDTO(personAllergy);
        return personAllergyDTO;
    }

    /**
     *  Delete the  personAllergy by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete PersonAllergy : {}", id);
        personAllergyRepository.delete(id);
    }
}
