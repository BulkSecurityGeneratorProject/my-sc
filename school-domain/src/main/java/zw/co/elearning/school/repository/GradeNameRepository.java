package zw.co.elearning.school.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.elearning.school.domain.GradeName;
import zw.co.elearning.school.domain.Vital;

/**
 * Spring Data JPA repository for the Vital entity.
 */
@SuppressWarnings("unused")
public interface GradeNameRepository extends JpaRepository<GradeName, String> {

}
