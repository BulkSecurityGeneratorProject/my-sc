package zw.co.elearning.school.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import zw.co.elearning.school.domain.SubjectActivity;
import zw.co.elearning.school.service.dto.SubjectActivityDTO;

/**
 * Mapper for the entity SubjectActivity and its DTO SubjectActivityDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SubjectActivityMapper {

    SubjectActivityDTO subjectActivityToSubjectActivityDTO(SubjectActivity subjectActivity);

    List<SubjectActivityDTO> subjectActivitysToSubjectActivityDTOs(List<SubjectActivity> subjectActivitys);

    SubjectActivity subjectActivityDTOToSubjectActivity(SubjectActivityDTO subjectActivityDTO);

    List<SubjectActivity> subjectActivityDTOsToSubjectActivitys(List<SubjectActivityDTO> subjectActivityDTOs);

    
}
