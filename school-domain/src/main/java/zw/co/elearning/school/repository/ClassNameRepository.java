package zw.co.elearning.school.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.elearning.school.domain.ClassName;

/**
 * Spring Data JPA repository for the ClassName entity.
 */
@SuppressWarnings("unused")
public interface ClassNameRepository extends JpaRepository<ClassName, String> {

	Page<ClassName> findByNameContainingAllIgnoringCase(String text,	Pageable pageable);

	List<ClassName> findByIdIn(List<Long> ids);

	List<ClassName> findByGradeName(String classNameId);


}
