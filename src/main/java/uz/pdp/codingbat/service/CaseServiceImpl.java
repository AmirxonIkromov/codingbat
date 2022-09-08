package uz.pdp.codingbat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.Case;
import uz.pdp.codingbat.entity.Problem;
import uz.pdp.codingbat.entity.Section;
import uz.pdp.codingbat.exception.InputDataExistsException;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.CaseDTO;
import uz.pdp.codingbat.payload.ProblemDTO;
import uz.pdp.codingbat.repository.CaseRepository;
import uz.pdp.codingbat.repository.ProblemRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CaseServiceImpl implements CaseService {

    private final ProblemRepository problemRepository;
    private final CaseRepository caseRepository;

    @Override
    public ApiResult add(CaseDTO caseDTO) {
        Problem problem = problemRepository.findById(caseDTO.getProblem_id()).orElseThrow(IllegalStateException::new);
        caseRepository.save(mapCaseDTOToCase(caseDTO,new Case(),problem));
        return new ApiResult(true,"success");
    }

    @Override
    public List<CaseDTO> getAll() {
        return caseRepository.findAll()
                .stream()
                .map(casee -> new CaseDTO(casee.getId(),
                        casee.getExpected(),casee.getArgs(),casee.getProblem().getId()))
                .toList();
    }

    @Override
    public CaseDTO get(Integer id) {
        Case aCase = caseRepository.findById(id).orElseThrow(IllegalStateException::new);
        return new CaseDTO(aCase.getId(),aCase.getExpected()
                ,aCase.getArgs(),aCase.getProblem().getId());
    }

    @Override
    public ApiResult edit(Integer id, CaseDTO caseDTO) {
        Problem problem = problemRepository.findById(caseDTO.getProblem_id()).orElseThrow(IllegalStateException::new);
        Case aCase = caseRepository.findById(id).orElseThrow(IllegalStateException::new);
        caseRepository.save(mapCaseDTOToCase(caseDTO,aCase,problem));
        return new ApiResult(true,"success");
    }

    @Override
    public ApiResult delete(Integer id) {
        Optional<Case> byId = caseRepository.findById(id);
        if (byId.isEmpty()) throw new InputDataExistsException("Bunday language Mavjud emas!");

        caseRepository.delete(byId.get());
        return new ApiResult(true, "OK");
    }

    private Case mapCaseDTOToCase(CaseDTO caseDTO, Case casee, Problem problem) {
        casee.setExpected(caseDTO.getExpected());
        casee.setArgs(caseDTO.getArgs());
        casee.setProblem(problem);
        return casee;
    }
}
