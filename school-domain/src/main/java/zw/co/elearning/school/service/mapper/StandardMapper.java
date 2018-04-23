package zw.co.elearning.school.service.mapper;

import zw.co.elearning.school.domain.*;
import zw.co.elearning.school.service.dto.StandardDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Standard and its DTO StandardDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StandardMapper {

    StandardDTO standardToStandardDTO(Standard standard);

    List<StandardDTO> standardsToStandardDTOs(List<Standard> standards);

    Standard standardDTOToStandard(StandardDTO standardDTO);

    List<Standard> standardDTOsToStandards(List<StandardDTO> standardDTOs);
}
