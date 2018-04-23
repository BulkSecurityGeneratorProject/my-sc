package zw.co.elearning.school.repository;

import zw.co.elearning.school.domain.Unit;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Unit entity.
 */
@SuppressWarnings("unused")
public interface UnitRepository extends JpaRepository<Unit,String> {

	List<Unit> findByIdIn(List<Long> unitIds);

}
