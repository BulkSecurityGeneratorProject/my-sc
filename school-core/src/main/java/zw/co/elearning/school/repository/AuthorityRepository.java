package zw.co.elearning.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.elearning.school.domain.Authority;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
