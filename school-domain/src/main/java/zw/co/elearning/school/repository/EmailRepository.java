package zw.co.elearning.school.repository;

import org.springframework.data.jpa.repository.*;

import zw.co.elearning.school.domain.Email;

import java.util.List;

/**
 * Spring Data JPA repository for the Email entity.
 */
@SuppressWarnings("unused")
public interface EmailRepository extends JpaRepository<Email,String> {

	List<Email> findByPersonId(String personId);

}
