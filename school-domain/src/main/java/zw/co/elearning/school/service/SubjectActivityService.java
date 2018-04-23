package zw.co.elearning.school.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import zw.co.elearning.school.service.dto.SubjectActivityDTO;

public interface SubjectActivityService {

	SubjectActivityDTO save(SubjectActivityDTO termDTO);

	Page<SubjectActivityDTO> findAll(Pageable pageable);

	void delete(String id);

	SubjectActivityDTO findOne(String id);

}
