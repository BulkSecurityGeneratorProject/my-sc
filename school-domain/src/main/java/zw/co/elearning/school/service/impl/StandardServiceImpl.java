package zw.co.elearning.school.service.impl;

import zw.co.elearning.school.service.StandardService;
import zw.co.elearning.school.domain.Standard;
import zw.co.elearning.school.repository.StandardRepository;
import zw.co.elearning.school.service.dto.StandardDTO;
import zw.co.elearning.school.service.mapper.StandardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Standard.
 */
@Service
@Transactional
public class StandardServiceImpl implements StandardService{

    private final Logger log = LoggerFactory.getLogger(StandardServiceImpl.class);
    
    private final StandardRepository standardRepository;

    private final StandardMapper standardMapper;

    public StandardServiceImpl(StandardRepository standardRepository, StandardMapper standardMapper) {
        this.standardRepository = standardRepository;
        this.standardMapper = standardMapper;
    }

    /**
     * Save a standard.
     *
     * @param standardDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public StandardDTO save(StandardDTO standardDTO) {
        log.debug("Request to save Standard : {}", standardDTO);
        Standard standard = standardMapper.standardDTOToStandard(standardDTO);
        standard = standardRepository.save(standard);
        StandardDTO result = standardMapper.standardToStandardDTO(standard);
        return result;
    }

    /**
     *  Get all the standards.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<StandardDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Standards");
        Page<Standard> result = standardRepository.findAll(pageable);
        return result.map(standard -> standardMapper.standardToStandardDTO(standard));
    }

    /**
     *  Get one standard by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public StandardDTO findOne(String id) {
        log.debug("Request to get Standard : {}", id);
        Standard standard = standardRepository.findOne(id);
        StandardDTO standardDTO = standardMapper.standardToStandardDTO(standard);
        return standardDTO;
    }

    /**
     *  Delete the  standard by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete Standard : {}", id);
        standardRepository.delete(id);
    }
}
