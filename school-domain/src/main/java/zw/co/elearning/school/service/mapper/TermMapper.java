package zw.co.elearning.school.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import zw.co.elearning.school.domain.Term;
import zw.co.elearning.school.service.dto.TermDTO;

/**
 * Mapper for the entity Term and its DTO TermDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TermMapper {

    TermDTO termToTermDTO(Term term);

    List<TermDTO> termsToTermDTOs(List<Term> terms);

    Term termDTOToTerm(TermDTO termDTO);

    List<Term> termDTOsToTerms(List<TermDTO> termDTOs);

    
}
