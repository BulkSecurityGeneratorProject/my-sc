package zw.co.elearning.school.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.elearning.school.domain.Term;
import zw.co.elearning.school.domain.Vital;

/**
 * Spring Data JPA repository for the Vital entity.
 */
@SuppressWarnings("unused")
public interface TermRepository extends JpaRepository<Term, String> {

	Page<Term> findByCodeContainingOrNameContainingAllIgnoringCase(Pageable pageable);



}
