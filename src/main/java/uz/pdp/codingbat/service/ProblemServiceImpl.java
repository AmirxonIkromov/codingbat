package uz.pdp.codingbat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.Case;
import uz.pdp.codingbat.entity.Problem;
import uz.pdp.codingbat.entity.Section;
import uz.pdp.codingbat.exception.InputDataExistsException;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.ProblemDTO;
import uz.pdp.codingbat.payload.SectionDTO;
import uz.pdp.codingbat.repository.ProblemRepository;
import uz.pdp.codingbat.repository.SectionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProblemServiceImpl implements  ProblemService{

    private final ProblemRepository problemRepository;

    private final SectionRepository sectionRepository;

    @Override
    public ApiResult add(ProblemDTO problemDTO) {
        Section section = sectionRepository.findById(problemDTO.getSection_id()).orElseThrow(IllegalStateException::new);
        problemRepository.save(mapProblemDTOToProblem(problemDTO,new Problem(),section));
        return new ApiResult(true,"success");
    }

    @Override
    public List<ProblemDTO> getAll() {
        return problemRepository.findAll()
                .stream()
                .map(problem -> new ProblemDTO(problem.getId(),
                        problem.getTitle(),problem.getDescription(),problem.getMethod(),problem.getSection().getId()))
                .toList();
    }

    @Override
    public ProblemDTO get(Integer id) {
        Problem problem = problemRepository.findById(id).orElseThrow(IllegalStateException::new);
        return new ProblemDTO(problem.getId(),problem.getTitle()
                ,problem.getDescription(),problem.getMethod(),problem.getSection().getId());
    }

    @Override
    public ApiResult edit(Integer id, ProblemDTO problemDTO) {
        Section section = sectionRepository.findById(problemDTO.getSection_id()).orElseThrow(IllegalStateException::new);
        Problem problem = problemRepository.findById(id).orElseThrow(IllegalStateException::new);
        problemRepository.save(mapProblemDTOToProblem(problemDTO,problem,section));
        return new ApiResult(true,"success");
    }

    @Override
    public ApiResult delete(Integer id) {
        Optional<Problem> byId = problemRepository.findById(id);
        if (byId.isEmpty()) throw new InputDataExistsException("Bunday problem Mavjud emas!");

        problemRepository.delete(byId.get());
        return new ApiResult(true, "OK");
    }

    private Problem mapProblemDTOToProblem(ProblemDTO problemDTO,Problem problem,Section section) {
        problem.setTitle(problemDTO.getTitle());
        problem.setDescription(problemDTO.getDescription());
        problem.setMethod(problemDTO.getMethod());
        return problem;
    }
}
