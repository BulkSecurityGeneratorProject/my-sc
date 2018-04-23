package zw.co.elearning.school.service.mapper;

import zw.co.elearning.school.domain.*;
import zw.co.elearning.school.service.dto.EmailDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Email and its DTO EmailDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmailMapper {

    @Mapping(source = "person.id", target = "personId")
    EmailDTO emailToEmailDTO(Email email);

    List<EmailDTO> emailsToEmailDTOs(List<Email> emails);

    @Mapping(source = "personId", target = "person")
    Email emailDTOToEmail(EmailDTO emailDTO);

    List<Email> emailDTOsToEmails(List<EmailDTO> emailDTOs);

    default Person personFromId(String id) {
        if (id == null) {
            return null;
        }
        Person person = new Person();
        person.setId(id);
        return person;
    }
}
