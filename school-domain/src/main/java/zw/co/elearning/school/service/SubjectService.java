package zw.co.elearning.school.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import zw.co.elearning.school.service.dto.SubjectDTO;

public interface SubjectService {

	SubjectDTO save(SubjectDTO subjectDTO);

	Page<SubjectDTO> findAll(Pageable pageable);

	List<SubjectDTO> findByIds(String[] ids);

	SubjectDTO findOne(String id);

	void delete(String id);

}
