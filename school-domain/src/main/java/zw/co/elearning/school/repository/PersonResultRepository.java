package zw.co.elearning.school.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.elearning.school.domain.PersonResult;

/**
 * Spring Data JPA repository for the Person entity.
 */
@SuppressWarnings("unused")
public interface PersonResultRepository extends JpaRepository<PersonResult, String> {

	List<PersonResult> findByTermIdAndClassNameIdAndSubjectActivityId(String termId, String classNameId,
			String subjectActivityID);

	//Page<PersonResult> findByCodeContainingOrNameContainingAllIgnoringCase(String text, String text2,
	//		Pageable pageable);

	//List<PersonResult> findByTermIdAndClassNameIdAndSubjectActivityId(String termId, String classNameId, String subjectActivityID);

	
}
