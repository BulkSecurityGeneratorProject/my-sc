package zw.co.elearning.school.repository;

import zw.co.elearning.school.domain.Standard;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Standard entity.
 */
@SuppressWarnings("unused")
public interface StandardRepository extends JpaRepository<Standard,String> {

}
