package zw.co.elearning.school.repository;

import org.springframework.data.jpa.repository.*;

import zw.co.elearning.school.domain.Phone;

import java.util.List;

/**
 * Spring Data JPA repository for the Phone entity.
 */
@SuppressWarnings("unused")
public interface PhoneRepository extends JpaRepository<Phone,String> {

	List<Phone> findByPersonIdIn(List<String> ids);

	List<Phone> findByPersonId(String personId);

}
