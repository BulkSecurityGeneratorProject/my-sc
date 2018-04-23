package zw.co.elearning.school.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zw.co.elearning.school.domain.Vital;
import zw.co.elearning.school.repository.VitalRepository;
import zw.co.elearning.school.service.VitalService;
import zw.co.elearning.school.service.dto.VitalDTO;
import zw.co.elearning.school.service.mapper.VitalMapper;

/**
 * Service Implementation for managing Vital.
 */
@Service
@Transactional
public class VitalServiceImpl implements VitalService {

	private final Logger log = LoggerFactory.getLogger(VitalServiceImpl.class);

	private final VitalRepository vitalRepository;

	private final VitalMapper vitalMapper;

	

	public VitalServiceImpl(VitalRepository vitalRepository, VitalMapper vitalMapper) {
		this.vitalRepository = vitalRepository;
		this.vitalMapper = vitalMapper;
	}

	/**
	 * Save a vital.
	 *
	 * @param vitalDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public VitalDTO save(VitalDTO vitalDTO) {
		log.debug("Request to save Vital : {}", vitalDTO);
		Vital vital = vitalMapper.vitalDTOToVital(vitalDTO);
		vital = vitalRepository.save(vital);
		VitalDTO result = vitalMapper.vitalToVitalDTO(vital);
		return result;
	}

	/**
	 * Get all the vitals.
	 * 
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<VitalDTO> findAll(String text, Pageable pageable) {
		log.debug("Request to get all Vitals");
		Page<Vital> result = vitalRepository.findByCodeContainingOrNameContainingAllIgnoringCase(text, text, pageable);
		return result.map(vital -> vitalMapper.vitalToVitalDTO(vital));
	}

	/**
	 * Get one vital by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	@Transactional(readOnly = true)
	public VitalDTO findOne(Long id) {
		log.debug("Request to get Vital : {}", id);
		Vital vital = vitalRepository.findOne(id);
		VitalDTO vitalDTO = vitalMapper.vitalToVitalDTO(vital);
		return vitalDTO;
	}

	/**
	 * Delete the vital by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(Long id) {
		log.debug("Request to delete Vital : {}", id);
		vitalRepository.delete(id);
	}

	
}
