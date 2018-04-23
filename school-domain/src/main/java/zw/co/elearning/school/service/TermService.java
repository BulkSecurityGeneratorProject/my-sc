package zw.co.elearning.school.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import zw.co.elearning.school.service.dto.TermDTO;

public interface TermService {

	TermDTO save(TermDTO termDTO);

	Page<TermDTO> findAll(Pageable pageable);

	void delete(String id);

	TermDTO findOne(String id);

}
