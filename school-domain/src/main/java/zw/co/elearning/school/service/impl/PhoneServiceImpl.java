package zw.co.elearning.school.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zw.co.elearning.school.domain.Phone;
import zw.co.elearning.school.repository.PhoneRepository;
import zw.co.elearning.school.service.PhoneService;
import zw.co.elearning.school.service.dto.PhoneDTO;
import zw.co.elearning.school.service.mapper.PhoneMapper;

/**
 * Service Implementation for managing Phone.
 */
@Service
@Transactional
public class PhoneServiceImpl implements PhoneService {

	private final Logger log = LoggerFactory.getLogger(PhoneServiceImpl.class);

	private final PhoneRepository phoneRepository;

	private final PhoneMapper phoneMapper;


	public PhoneServiceImpl(PhoneRepository phoneRepository, PhoneMapper phoneMapper) {
		this.phoneRepository = phoneRepository;
		this.phoneMapper = phoneMapper;
	
	}

	/**
	 * Save a phone.
	 *
	 * @param phoneDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public PhoneDTO save(PhoneDTO phoneDTO) {
		log.debug("Request to save Phone : {}", phoneDTO);
		Phone phone = phoneMapper.phoneDTOToPhone(phoneDTO);
		phone = phoneRepository.save(phone);
		PhoneDTO result = phoneMapper.phoneToPhoneDTO(phone);
		return result;
	}

	/**
	 * Get all the phones.
	 * 
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<PhoneDTO> findAll(Pageable pageable) {
		log.debug("Request to get all Phones");
		Page<Phone> result = phoneRepository.findAll(pageable);
		return result.map(phone -> phoneMapper.phoneToPhoneDTO(phone));
	}

	/**
	 * Get one phone by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	@Transactional(readOnly = true)
	public PhoneDTO findOne(String id) {
		log.debug("Request to get Phone : {}", id);
		Phone phone = phoneRepository.findOne(id);
		PhoneDTO phoneDTO = phoneMapper.phoneToPhoneDTO(phone);
		return phoneDTO;
	}

	/**
	 * Delete the phone by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(String id) {
		log.debug("Request to delete Phone : {}", id);
		phoneRepository.delete(id);
	}

	

	@Override
	public List<PhoneDTO> findByPersonId(String personId) {
		List<Phone> result = phoneRepository.findByPersonId(personId);
		return phoneMapper.phonesToPhoneDTOs(result);
	}
}
