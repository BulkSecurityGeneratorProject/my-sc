package zw.co.elearning.school.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zw.co.elearning.school.domain.GradeName;
import zw.co.elearning.school.repository.GradeNameRepository;
import zw.co.elearning.school.service.GradeNameService;
import zw.co.elearning.school.service.dto.GradeNameDTO;
import zw.co.elearning.school.service.mapper.GradeNameMapper;

/**
 * Service Implementation for managing GradeName.
 */
@Service
@Transactional
public class GradeNameServiceImpl implements GradeNameService {

	private final Logger log = LoggerFactory.getLogger(GradeNameServiceImpl.class);

	private final GradeNameRepository gradeNameRepository;

	private final GradeNameMapper gradeNameMapper;

	

	public GradeNameServiceImpl(GradeNameRepository gradeNameRepository, GradeNameMapper gradeNameMapper) {
		this.gradeNameRepository = gradeNameRepository;
		this.gradeNameMapper = gradeNameMapper;
	}

	/**
	 * Save a gradeName.
	 *
	 * @param gradeNameDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public GradeNameDTO save(GradeNameDTO gradeNameDTO) {
		log.debug("Request to save GradeName : {}", gradeNameDTO);
		GradeName gradeName = gradeNameMapper.gradeNameDTOToGradeName(gradeNameDTO);
		gradeName = gradeNameRepository.save(gradeName);
		GradeNameDTO result = gradeNameMapper.gradeNameToGradeNameDTO(gradeName);
		return result;
	}

	/**
	 * Get all the gradeNames.
	 * 
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<GradeNameDTO> findAll(Pageable pageable) {
		log.debug("Request to get all GradeNames");
		Page<GradeName> result = gradeNameRepository.findAll(pageable);
		return result.map(gradeName -> gradeNameMapper.gradeNameToGradeNameDTO(gradeName));
	}

	/**
	 * Get one gradeName by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	@Transactional(readOnly = true)
	public GradeNameDTO findOne(String id) {
		log.debug("Request to get GradeName : {}", id);
		GradeName gradeName = gradeNameRepository.findOne(id);
		GradeNameDTO gradeNameDTO = gradeNameMapper.gradeNameToGradeNameDTO(gradeName);
		return gradeNameDTO;
	}

	/**
	 * Delete the gradeName by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(String id) {
		log.debug("Request to delete GradeName : {}", id);
		gradeNameRepository.delete(id);
	}

	
}
