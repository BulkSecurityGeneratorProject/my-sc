package zw.co.elearning.school.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import zw.co.elearning.school.domain.Standard;
import zw.co.elearning.school.domain.Unit;
import zw.co.elearning.school.domain.Subject;
import zw.co.elearning.school.service.dto.SubjectDTO;

/**
 * Mapper for the entity Subject and its DTO SubjectDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SubjectMapper {


    SubjectDTO subjectToSubjectDTO(Subject subject);

    List<SubjectDTO> subjectsToSubjectDTOs(List<Subject> subjects);


    Subject subjectDTOToSubject(SubjectDTO subjectDTO);

    List<Subject> subjectDTOsToSubjects(List<SubjectDTO> subjectDTOs);

    
}
