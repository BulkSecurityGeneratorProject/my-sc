package zw.co.elearning.school.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import zw.co.elearning.school.service.dto.GradeNameDTO;

public interface GradeNameService {

	GradeNameDTO save(GradeNameDTO termDTO);

	Page<GradeNameDTO> findAll(Pageable pageable);

	void delete(String id);

	GradeNameDTO findOne(String id);

}
