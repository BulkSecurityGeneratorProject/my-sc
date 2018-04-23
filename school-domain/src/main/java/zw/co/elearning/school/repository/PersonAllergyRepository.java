package zw.co.elearning.school.repository;

import org.springframework.data.jpa.repository.*;

import zw.co.elearning.school.domain.PersonAllergy;

import java.util.List;

/**
 * Spring Data JPA repository for the PersonAllergy entity.
 */
@SuppressWarnings("unused")
public interface PersonAllergyRepository extends JpaRepository<PersonAllergy,Long> {

}
