package zw.co.elearning.school.service.mapper;

import zw.co.elearning.school.domain.*;
import zw.co.elearning.school.service.dto.UnitDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Unit and its DTO UnitDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UnitMapper {

    @Mapping(source = "standard.id", target = "standardId")
    UnitDTO unitToUnitDTO(Unit unit);

    List<UnitDTO> unitsToUnitDTOs(List<Unit> units);

    @Mapping(source = "standardId", target = "standard")
    Unit unitDTOToUnit(UnitDTO unitDTO);

    List<Unit> unitDTOsToUnits(List<UnitDTO> unitDTOs);

    default Standard standardFromId(String id) {
        if (id == null) {
            return null;
        }
        Standard standard = new Standard();
        standard.setId(id);
        return standard;
    }
}
