package zw.co.elearning.school.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import zw.co.elearning.school.domain.ClassName;
import zw.co.elearning.school.domain.Person;
import zw.co.elearning.school.domain.PersonResult;
import zw.co.elearning.school.domain.SubjectActivity;
import zw.co.elearning.school.domain.Term;
import zw.co.elearning.school.service.dto.PersonResultDTO;

/**
 * Mapper for the entity PersonResult and its DTO PersonResultDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PersonResultMapper {
	
	@Mapping(source = "className.id", target = "classNameId")
	@Mapping(source = "person.id", target = "personId")
	@Mapping(source = "subjectActivity.id", target = "subjectActivityId")
	@Mapping(source = "term.id", target = "termId")
	PersonResultDTO personResultToPersonResultDTO(PersonResult personResult);

    List<PersonResultDTO> personResultsToPersonResultDTOs(List<PersonResult> personResults);

    @Mapping(source = "classNameId", target = "className")
    @Mapping(source = "personId", target = "person")
    @Mapping(source = "subjectActivityId", target = "subjectActivity")
    @Mapping(source = "termId", target = "term")
    PersonResult personResultDTOToPersonResult(PersonResultDTO personResultDTO);

    List<PersonResult> personResultDTOsToPersonResults(List<PersonResultDTO> personResultDTOs);

    default ClassName classnameFromId(String id) {
        if (id == null) {
            return null;
        }
        ClassName classname = new ClassName();
        classname.setId(id);
        return classname;
    }

    default Person personFromId(String id) {
        if (id == null) {
            return null;
        }
        Person person = new Person();
        person.setId(id);
        return person;
    }
    
    default SubjectActivity subjectActivityFromId(String id) {
        if (id == null) {
            return null;
        }
        SubjectActivity subjectActivity = new SubjectActivity();
        subjectActivity.setId(id);
        return subjectActivity;
    }
    
    default Term termFromId(String id) {
        if (id == null) {
            return null;
        }
        Term term = new Term();
        term.setId(id);
        return term;
    }
}
