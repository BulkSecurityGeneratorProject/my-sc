package zw.co.elearning.school.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import zw.co.elearning.school.domain.ClassName;
import zw.co.elearning.school.domain.ClassName;
import zw.co.elearning.school.domain.GradeName;
import zw.co.elearning.school.service.dto.ClassNameDTO;

/**
 * Mapper for the entity ClassName and its DTO ClassNameDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ClassNameMapper {

	@Mapping(source = "gradeName.id", target = "gradeNameId")
    ClassNameDTO classNameToClassNameDTO(ClassName className);
	

    List<ClassNameDTO> peopleToClassNameDTOs(List<ClassName> people);

    @Mapping(source = "gradeNameId", target = "gradeName")
    ClassName classNameDTOToClassName(ClassNameDTO classNameDTO);

    List<ClassName> classNameDTOsToPeople(List<ClassNameDTO> classNameDTOs);
    

    default GradeName gradenameFromId(String id) {
        if (id == null) {
            return null;
        }
        GradeName gradename = new GradeName();
        gradename.setId(id);
        return gradename;
    }


    
}
