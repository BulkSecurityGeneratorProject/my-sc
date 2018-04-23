package zw.co.elearning.school.repository;

import zw.co.elearning.school.domain.Allergy;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Allergy entity.
 */
@SuppressWarnings("unused")
public interface AllergyRepository extends JpaRepository<Allergy,String> {

}
