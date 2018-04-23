package zw.co.elearning.school.service.impl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zw.co.elearning.school.domain.PersonVital;
import zw.co.elearning.school.domain.util.DateUtils;
import zw.co.elearning.school.repository.PersonVitalRepository;
import zw.co.elearning.school.repository.SiteSettingRepository;
import zw.co.elearning.school.service.PersonVitalService;
import zw.co.elearning.school.service.VitalService;
import zw.co.elearning.school.service.dto.PersonVitalDTO;
import zw.co.elearning.school.service.mapper.PersonVitalMapper;

/**
 * Service Implementation for managing PersonVital.
 */
@Service
@Transactional
public class PersonVitalServiceImpl implements PersonVitalService {

	private final Logger log = LoggerFactory.getLogger(PersonVitalServiceImpl.class);

	private final PersonVitalRepository personVitalRepository;

	private final PersonVitalMapper personVitalMapper;

	@Inject
	private SiteSettingRepository siteSettingRepository;

	@Inject
	private VitalService vitalService;

	@Inject
	private DateUtils dateUtils;



	public PersonVitalServiceImpl(PersonVitalRepository personVitalRepository, PersonVitalMapper personVitalMapper) {
		this.personVitalRepository = personVitalRepository;
		this.personVitalMapper = personVitalMapper;
	}

	/**
	 * Save a personVital.
	 *
	 * @param personVitalDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public PersonVitalDTO save(PersonVitalDTO personVitalDTO) {
		log.debug("Request to save PersonVital : {}", personVitalDTO);
		PersonVital personVital = personVitalMapper.personVitalDTOToPersonVital(personVitalDTO);
		personVital = personVitalRepository.save(personVital);
		PersonVitalDTO result = personVitalMapper.personVitalToPersonVitalDTO(personVital);
		return result;
	}

	/**
	 * Get all the personVitals.
	 * 
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<PersonVitalDTO> findAll(Pageable pageable) {
		log.debug("Request to get all PersonVitals");
		Page<PersonVital> result = personVitalRepository.findAll(pageable);
		return result.map(personVital -> personVitalMapper.personVitalToPersonVitalDTO(personVital));
	}

	/**
	 * Get one personVital by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	@Transactional(readOnly = true)
	public PersonVitalDTO findOne(String id) {
		log.debug("Request to get PersonVital : {}", id);
		PersonVital personVital = personVitalRepository.findOne(id);
		PersonVitalDTO personVitalDTO = personVitalMapper.personVitalToPersonVitalDTO(personVital);
		return personVitalDTO;
	}

	/**
	 * Delete the personVital by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(String id) {
		log.debug("Request to delete PersonVital : {}", id);
		personVitalRepository.delete(id);
	}

	@Override
	public List<PersonVitalDTO> findByIds(String[] ids) {
		List<PersonVital> result = personVitalRepository.findByIdIn(Arrays.asList(ids));
		return personVitalMapper.personVitalsToPersonVitalDTOs(result);
	}



	

	@Override
	public Page<PersonVitalDTO> getByPersonIdAndDateBetweenForPartogram(String personId, LocalDateTime from,
			LocalDateTime to, Pageable pageable) {
		log.debug("<<<<<<<========im in here nigaaaaaaa========>>>>>>>>>>>");
		log.debug("<<<<<<<========im in here nigaaaaaaa========>>>>>>>>>>>" + from);

		Page<PersonVital> result = personVitalRepository.getByPersonIdAndDateBetween(personId, from, to, pageable);
		return result.map(personVital -> personVitalMapper.personVitalToPersonVitalDTO(personVital));

	}

	@Override
	public List<Map<String, Object>> findByPersonIdVitalIdAndDateBetween(String deliveryId, Long personId, Long vitalId,
			LocalDateTime from, LocalDateTime to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonVitalDTO findByVitalIdAndPersonIdAndDate(String personId, Long vitalId, LocalDateTime date) {
		// TODO Auto-generated method stub
		return null;
	}

	





/*	
	@Override
	public PersonVitalDTO findByVitalIdAndPersonIdAndDate(String personId, String vitalId, LocalDateTime date) {
		PersonVital personVital = personVitalRepository.findByPersonIdAndVitalIdAndDate(personId, vitalId, date);
		PersonVitalDTO personVitalDTO = personVitalMapper.personVitalToPersonVitalDTO(personVital);

		return personVitalDTO;
	}*/

	

}
