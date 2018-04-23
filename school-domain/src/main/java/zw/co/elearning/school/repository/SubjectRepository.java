package zw.co.elearning.school.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.elearning.school.domain.Subject;

/**
 * Spring Data JPA repository for the Vital entity.
 */
@SuppressWarnings("unused")
public interface SubjectRepository extends JpaRepository<Subject, String> {

	Page<Subject> findByCodeContainingOrNameContainingAllIgnoringCase(String text, String text2, Pageable pageable);

	void delete(String id);

}
