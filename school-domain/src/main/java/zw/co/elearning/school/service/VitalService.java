package zw.co.elearning.school.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import zw.co.elearning.school.service.dto.VitalDTO;

/**
 * Service Interface for managing Vital.
 */
public interface VitalService {

	String BP_ID = "VITAL_BP_ID";
	String HEIGHT_ID = "VITAL_HEIGHT_ID";
	String PULSE_ID = "VITAL_PULSE_ID";
	String RR_ID = "VITAL_RR_ID";
	String TEMPERATURE_ID = "VITAL_TEMPERATURE_ID";
	String WEIGHT_ID = "VITAL_WEIGHT_ID";
	String BLOOD_PRESSURE_ID = "VITAL_BLOOD_PRESSURE_ID";
	String FOETAL_HEART_RATE_ID = "VITAL_FOETAL_HEART_RATE_ID";
	String HEAD_CIRCUMFERENCE_ID = "VITAL_HEAD_CIRCUMFERENCE_ID";
	String MUAC_ID = "VITAL_MUAC_ID";
	String HEIGHT_OF_FUNDUS_ID = "VITAL_HEIGHT_OF_FUNDUS_ID";
	
	String DIASTOLIC_MAX = "DIASTOLIC_MAX";
	String DIASTOLIC_MIN = "DIASTOLIC_MIN";
	/**
	 *  
	 * Save a vital.
	 *
	 * @param vitalDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	VitalDTO save(VitalDTO vitalDTO);

	/**
	 * Get all the vitals.
	 * 
	 * @param text
	 * 
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	Page<VitalDTO> findAll(String text, Pageable pageable);

	/**
	 * Get the "id" vital.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	VitalDTO findOne(Long id);

	/**
	 * Delete the "id" vital.
	 *
	 * @param id
	 *            the id of the entity
	 */
	void delete(Long id);
	
	
}
