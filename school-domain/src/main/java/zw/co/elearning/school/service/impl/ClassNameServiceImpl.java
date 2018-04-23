package zw.co.elearning.school.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zw.co.elearning.school.domain.ClassName;
import zw.co.elearning.school.repository.ClassNameRepository;
import zw.co.elearning.school.service.ClassNameService;
import zw.co.elearning.school.service.dto.ClassNameDTO;
import zw.co.elearning.school.service.mapper.ClassNameMapper;

/**
 * Service Implementation for managing ClassName.
 */
@Service
@Transactional
public class ClassNameServiceImpl implements ClassNameService {

	private final Logger log = LoggerFactory.getLogger(ClassNameServiceImpl.class);

	private final ClassNameRepository classNameRepository;

	private final ClassNameMapper classNameMapper;

	public ClassNameServiceImpl(ClassNameRepository classNameRepository, ClassNameMapper classNameMapper) {
		this.classNameRepository = classNameRepository;
		this.classNameMapper = classNameMapper;

	}

	/**
	 * Save a className.
	 *
	 * @param classNameDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public ClassNameDTO save(ClassNameDTO classNameDTO) {
		log.debug("Request to save ClassName : {}", classNameDTO);
		ClassName className = classNameMapper.classNameDTOToClassName(classNameDTO);
		className = classNameRepository.save(className);
		ClassNameDTO result = classNameMapper.classNameToClassNameDTO(className);
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
	public Page<ClassNameDTO> findAll(String text, Pageable pageable) {
		log.debug("Request to get all People");

		Page<ClassName> result = null;

		result = classNameRepository.findByNameContainingAllIgnoringCase(text, pageable);

		return result.map(className -> classNameMapper.classNameToClassNameDTO(className));
	}

	/**
	 * Get one className by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	@Transactional(readOnly = true)
	public ClassNameDTO findOne(String id) {
		log.debug("Request to get ClassName : {}", id);
		ClassName className = classNameRepository.findOne(id);
		ClassNameDTO classNameDTO = classNameMapper.classNameToClassNameDTO(className);
		return classNameDTO;
	}

	/**
	 * Delete the className by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(String id) {
		log.debug("Request to delete ClassName : {}", id);
		classNameRepository.delete(id);
	}


}
