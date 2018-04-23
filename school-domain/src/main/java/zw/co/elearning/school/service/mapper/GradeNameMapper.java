package zw.co.elearning.school.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import zw.co.elearning.school.domain.GradeName;
import zw.co.elearning.school.service.dto.GradeNameDTO;

/**
 * Mapper for the entity GradeName and its DTO GradeNameDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface GradeNameMapper {

    GradeNameDTO gradeNameToGradeNameDTO(GradeName gradeName);

    List<GradeNameDTO> gradeNamesToGradeNameDTOs(List<GradeName> gradeNames);

    GradeName gradeNameDTOToGradeName(GradeNameDTO gradeNameDTO);

    List<GradeName> gradeNameDTOsToGradeNames(List<GradeNameDTO> gradeNameDTOs);

    
}
