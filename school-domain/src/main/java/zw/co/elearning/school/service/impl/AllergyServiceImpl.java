package zw.co.elearning.school.service.impl;

import zw.co.elearning.school.domain.Allergy;
import zw.co.elearning.school.repository.AllergyRepository;
import zw.co.elearning.school.service.AllergyService;
import zw.co.elearning.school.service.dto.AllergyDTO;
import zw.co.elearning.school.service.mapper.AllergyMapper;

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
 * Service Implementation for managing Allergy.
 */
@Service
@Transactional
public class AllergyServiceImpl implements AllergyService{

    private final Logger log = LoggerFactory.getLogger(AllergyServiceImpl.class);
    
    private final AllergyRepository allergyRepository;

    private final AllergyMapper allergyMapper;

    public AllergyServiceImpl(AllergyRepository allergyRepository, AllergyMapper allergyMapper) {
        this.allergyRepository = allergyRepository;
        this.allergyMapper = allergyMapper;
    }

    /**
     * Save a allergy.
     *
     * @param allergyDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public AllergyDTO save(AllergyDTO allergyDTO) {
        log.debug("Request to save Allergy : {}", allergyDTO);
        Allergy allergy = allergyMapper.allergyDTOToAllergy(allergyDTO);
        allergy = allergyRepository.save(allergy);
        AllergyDTO result = allergyMapper.allergyToAllergyDTO(allergy);
        return result;
    }

    /**
     *  Get all the allergies.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<AllergyDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Allergies");
        Page<Allergy> result = allergyRepository.findAll(pageable);
        return result.map(allergy -> allergyMapper.allergyToAllergyDTO(allergy));
    }

    /**
     *  Get one allergy by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public AllergyDTO findOne(String id) {
        log.debug("Request to get Allergy : {}", id);
        Allergy allergy = allergyRepository.findOne(id);
        AllergyDTO allergyDTO = allergyMapper.allergyToAllergyDTO(allergy);
        return allergyDTO;
    }

    /**
     *  Delete the  allergy by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete Allergy : {}", id);
        allergyRepository.delete(id);
    }
}
