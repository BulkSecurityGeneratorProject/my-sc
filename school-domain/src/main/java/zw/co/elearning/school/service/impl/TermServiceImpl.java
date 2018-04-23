package zw.co.elearning.school.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zw.co.elearning.school.domain.Term;
import zw.co.elearning.school.repository.TermRepository;
import zw.co.elearning.school.service.TermService;
import zw.co.elearning.school.service.dto.TermDTO;
import zw.co.elearning.school.service.mapper.TermMapper;

/**
 * Service Implementation for managing Term.
 */
@Service
@Transactional
public class TermServiceImpl implements TermService {

	private final Logger log = LoggerFactory.getLogger(TermServiceImpl.class);

	private final TermRepository termRepository;

	private final TermMapper termMapper;

	

	public TermServiceImpl(TermRepository termRepository, TermMapper termMapper) {
		this.termRepository = termRepository;
		this.termMapper = termMapper;
	}

	/**
	 * Save a term.
	 *
	 * @param termDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public TermDTO save(TermDTO termDTO) {
		log.debug("Request to save Term : {}", termDTO);
		Term term = termMapper.termDTOToTerm(termDTO);
		term = termRepository.save(term);
		TermDTO result = termMapper.termToTermDTO(term);
		return result;
	}

	/**
	 * Get all the terms.
	 * 
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<TermDTO> findAll(Pageable pageable) {
		log.debug("Request to get all Terms");
		Page<Term> result = termRepository.findAll(pageable);
		return result.map(term -> termMapper.termToTermDTO(term));
	}

	/**
	 * Get one term by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	@Transactional(readOnly = true)
	public TermDTO findOne(String id) {
		log.debug("Request to get Term : {}", id);
		Term term = termRepository.findOne(id);
		TermDTO termDTO = termMapper.termToTermDTO(term);
		return termDTO;
	}

	/**
	 * Delete the term by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(String id) {
		log.debug("Request to delete Term : {}", id);
		termRepository.delete(id);
	}

	
}
