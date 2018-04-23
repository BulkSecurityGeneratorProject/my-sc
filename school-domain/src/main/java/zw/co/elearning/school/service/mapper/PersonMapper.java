package zw.co.elearning.school.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import zw.co.elearning.school.domain.ClassName;
import zw.co.elearning.school.domain.Person;
import zw.co.elearning.school.service.dto.PersonDTO;

/**
 * Mapper for the entity Person and its DTO PersonDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PersonMapper {

	@Mapping(source = "className.id", target = "classNameId")
    PersonDTO personToPersonDTO(Person person);
	

    List<PersonDTO> peopleToPersonDTOs(List<Person> people);

    @Mapping(source = "classNameId", target = "className")
    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "phones", ignore = true)
    @Mapping(target = "emails", ignore = true)
    Person personDTOToPerson(PersonDTO personDTO);

    List<Person> personDTOsToPeople(List<PersonDTO> personDTOs);
    

    default ClassName classnameFromId(String id) {
        if (id == null) {
            return null;
        }
        ClassName classname = new ClassName();
        classname.setId(id);
        return classname;
    }


    
}
