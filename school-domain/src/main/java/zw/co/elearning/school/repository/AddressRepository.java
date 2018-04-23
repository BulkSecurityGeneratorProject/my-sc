package zw.co.elearning.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.elearning.school.domain.Address;

/**
 * Spring Data JPA repository for the Address entity.
 */
@SuppressWarnings("unused")
public interface AddressRepository extends JpaRepository<Address,String> {

	List<Address> findByPersonId(String personId);

}
