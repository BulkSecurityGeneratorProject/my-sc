package zw.co.elearning.school.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import zw.co.elearning.school.domain.Allergy;
import zw.co.elearning.school.service.dto.AllergyDTO;

/**
 * Mapper for the entity Allergy and its DTO AllergyDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AllergyMapper {

   

    List<AllergyDTO> allergiesToAllergyDTOs(List<Allergy> allergies);

   

    List<Allergy> allergyDTOsToAllergies(List<AllergyDTO> allergyDTOs);



	Allergy allergyDTOToAllergy(AllergyDTO allergyDTO);



	AllergyDTO allergyToAllergyDTO(Allergy allergy);

  
}
