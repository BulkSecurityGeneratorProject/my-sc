package zw.co.elearning.school.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zw.co.elearning.school.domain.SubjectActivity;
import zw.co.elearning.school.repository.SubjectActivityRepository;
import zw.co.elearning.school.service.SubjectActivityService;
import zw.co.elearning.school.service.dto.SubjectActivityDTO;
import zw.co.elearning.school.service.mapper.SubjectActivityMapper;

/**
 * Service Implementation for managing SubjectActivity.
 */
@Service
@Transactional
public class SubjectActivityServiceImpl implements SubjectActivityService {

	private final Logger log = LoggerFactory.getLogger(SubjectActivityServiceImpl.class);

	private final SubjectActivityRepository subjectActivityRepository;

	private final SubjectActivityMapper subjectActivityMapper;

	

	public SubjectActivityServiceImpl(SubjectActivityRepository subjectActivityRepository, SubjectActivityMapper subjectActivityMapper) {
		this.subjectActivityRepository = subjectActivityRepository;
		this.subjectActivityMapper = subjectActivityMapper;
	}

	/**
	 * Save a subjectActivity.
	 *
	 * @param subjectActivityDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public SubjectActivityDTO save(SubjectActivityDTO subjectActivityDTO) {
		log.debug("Request to save SubjectActivity : {}", subjectActivityDTO);
		SubjectActivity subjectActivity = subjectActivityMapper.subjectActivityDTOToSubjectActivity(subjectActivityDTO);
		subjectActivity = subjectActivityRepository.save(subjectActivity);
		SubjectActivityDTO result = subjectActivityMapper.subjectActivityToSubjectActivityDTO(subjectActivity);
		return result;
	}

	/**
	 * Get all the subjectActivitys.
	 * 
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<SubjectActivityDTO> findAll(Pageable pageable) {
		log.debug("Request to get all SubjectActivitys");
		Page<SubjectActivity> result = subjectActivityRepository.findAll(pageable);
		return result.map(subjectActivity -> subjectActivityMapper.subjectActivityToSubjectActivityDTO(subjectActivity));
	}

	/**
	 * Get one subjectActivity by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	@Transactional(readOnly = true)
	public SubjectActivityDTO findOne(String id) {
		log.debug("Request to get SubjectActivity : {}", id);
		SubjectActivity subjectActivity = subjectActivityRepository.findOne(id);
		SubjectActivityDTO subjectActivityDTO = subjectActivityMapper.subjectActivityToSubjectActivityDTO(subjectActivity);
		return subjectActivityDTO;
	}

	/**
	 * Delete the subjectActivity by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(String id) {
		log.debug("Request to delete SubjectActivity : {}", id);
		subjectActivityRepository.delete(id);
	}

	
}
