package zw.co.elearning.school.domain.util;

import java.time.LocalDate;

import zw.co.elearning.school.domain.Person;
import zw.co.elearning.school.domain.enumeration.Gender;
import zw.co.elearning.school.service.dto.PersonDTO;

public final class PersonUtil {

	public static PersonDTO createDTO(String firstname, String lastname) {

		PersonDTO result = new PersonDTO();

		result.setBirthdate(LocalDate.now());
		result.setFirstname(firstname);
		result.setLastname(lastname);
		result.setSex(Gender.UNKNOWN);

		return result;
	}

	public static Person create(String firstname, String lastname) {
		Person result = new Person();

		result.setBirthdate(LocalDate.now());
		result.setFirstname(firstname);
		result.setLastname(lastname);
		result.setSex(Gender.UNKNOWN);

		return result;
	}
}
