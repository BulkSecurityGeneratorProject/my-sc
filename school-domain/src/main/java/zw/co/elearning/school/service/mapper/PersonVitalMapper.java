package zw.co.elearning.school.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import zw.co.elearning.school.domain.Person;
import zw.co.elearning.school.domain.PersonVital;
import zw.co.elearning.school.domain.Vital;
import zw.co.elearning.school.service.dto.PersonVitalDTO;

/**
 * Mapper for the entity PersonVital and its DTO PersonVitalDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PersonVitalMapper {

    @Mapping(source = "person.id", target = "personId")
    @Mapping(source = "vital.id", target = "vitalId")
    PersonVitalDTO personVitalToPersonVitalDTO(PersonVital personVital);

    List<PersonVitalDTO> personVitalsToPersonVitalDTOs(List<PersonVital> personVitals);

    @Mapping(source = "personId", target = "person")
    @Mapping(source = "vitalId", target = "vital")
    PersonVital personVitalDTOToPersonVital(PersonVitalDTO personVitalDTO);

    List<PersonVital> personVitalDTOsToPersonVitals(List<PersonVitalDTO> personVitalDTOs);

    default Person personFromId(String id) {
        if (id == null) {
            return null;
        }
        Person person = new Person();
        person.setId(id);
        return person;
    }

    default Vital vitalFromId(String id) {
        if (id == null) {
            return null;
        }
        Vital vital = new Vital();
        vital.setId(id);
        return vital;
    }
}
