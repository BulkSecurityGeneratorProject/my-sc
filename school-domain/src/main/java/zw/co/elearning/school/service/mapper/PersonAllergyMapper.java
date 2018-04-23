package zw.co.elearning.school.service.mapper;

import zw.co.elearning.school.domain.*;
import zw.co.elearning.school.service.dto.PersonAllergyDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity PersonAllergy and its DTO PersonAllergyDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PersonAllergyMapper {

    @Mapping(source = "person.id", target = "personId")
    @Mapping(source = "allergy.id", target = "allergyId")
    PersonAllergyDTO personAllergyToPersonAllergyDTO(PersonAllergy personAllergy);

    List<PersonAllergyDTO> personAllergiesToPersonAllergyDTOs(List<PersonAllergy> personAllergies);

    @Mapping(source = "personId", target = "person")
    @Mapping(source = "allergyId", target = "allergy")
    PersonAllergy personAllergyDTOToPersonAllergy(PersonAllergyDTO personAllergyDTO);

    List<PersonAllergy> personAllergyDTOsToPersonAllergies(List<PersonAllergyDTO> personAllergyDTOs);

    default Person personFromId(String id) {
        if (id == null) {
            return null;
        }
        Person person = new Person();
        person.setId(id);
        return person;
    }

    default Allergy allergyFromId(String id) {
        if (id == null) {
            return null;
        }
        Allergy allergy = new Allergy();
        allergy.setId(id);
        return allergy;
    }
}
