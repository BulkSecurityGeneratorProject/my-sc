package zw.co.elearning.school.domain.util;

import java.time.LocalDateTime;

import zw.co.elearning.school.domain.Person;
import zw.co.elearning.school.domain.PersonVital;
import zw.co.elearning.school.domain.Vital;
import zw.co.elearning.school.service.dto.SiteSettingDTO;

public final class PersonVitalUtil {

	public static PersonVital create(String personId, SiteSettingDTO vitalId) throws Exception {

		if (vitalId == null) {
			throw new Exception("Vitals configuration not set in site settings");
		}

		PersonVital result = new PersonVital();

		result.setDate(LocalDateTime.now());
		result.setVital(new Vital());
		result.setPerson(new Person());

		result.getVital().setId(vitalId.getValue());
		result.getPerson().setId(personId);

		return result;
	}
}
