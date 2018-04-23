package zw.co.elearning.school.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import zw.co.elearning.school.domain.Standard;
import zw.co.elearning.school.domain.Unit;
import zw.co.elearning.school.domain.Vital;
import zw.co.elearning.school.service.dto.VitalDTO;

/**
 * Mapper for the entity Vital and its DTO VitalDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VitalMapper {

    @Mapping(source = "standard.id", target = "standardId")
    @Mapping(source = "unit.id", target = "unitId")
    VitalDTO vitalToVitalDTO(Vital vital);

    List<VitalDTO> vitalsToVitalDTOs(List<Vital> vitals);

    @Mapping(source = "standardId", target = "standard")
    @Mapping(source = "unitId", target = "unit")
    Vital vitalDTOToVital(VitalDTO vitalDTO);

    List<Vital> vitalDTOsToVitals(List<VitalDTO> vitalDTOs);

    default Standard standardFromId(String id) {
        if (id == null) {
            return null;
        }
        Standard standard = new Standard();
        standard.setId(id);
        return standard;
    }

    default Unit unitFromId(String id) {
        if (id == null) {
            return null;
        }
        Unit unit = new Unit();
        unit.setId(id);
        return unit;
    }
}
