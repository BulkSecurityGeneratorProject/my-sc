package zw.co.elearning.school.service.mapper;

import zw.co.elearning.school.domain.*;
import zw.co.elearning.school.service.dto.PhoneDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Phone and its DTO PhoneDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PhoneMapper {

    @Mapping(source = "person.id", target = "personId")
    PhoneDTO phoneToPhoneDTO(Phone phone);

    List<PhoneDTO> phonesToPhoneDTOs(List<Phone> phones);

    @Mapping(source = "personId", target = "person")
    Phone phoneDTOToPhone(PhoneDTO phoneDTO);

    List<Phone> phoneDTOsToPhones(List<PhoneDTO> phoneDTOs);

    default Person personFromId(String id) {
        if (id == null) {
            return null;
        }
        Person person = new Person();
        person.setId(id);
        return person;
    }
}
