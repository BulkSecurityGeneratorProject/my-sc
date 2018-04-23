package zw.co.elearning.school.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.elearning.school.domain.Person;

/**
 * Spring Data JPA repository for the Person entity.
 */
@SuppressWarnings("unused")
public interface PersonRepository extends JpaRepository<Person, String> {

	Page<Person> findByLastnameContainingOrFirstnameContainingAllIgnoringCase(String text, String text2,
			Pageable pageable);

	List<Person> findByIdIn(List<Long> ids);

	Page<Person> findByLastnameAndFirstnameContainingAllIgnoringCase(String text, String text2, Pageable pageable);

	List<Person> findByClassNameId(String classNameId);


}
