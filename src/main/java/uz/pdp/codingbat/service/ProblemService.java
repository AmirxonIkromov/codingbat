package uz.pdp.codingbat.service;

import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.ProblemDTO;

import java.util.List;

public interface ProblemService {

    ApiResult add(ProblemDTO problemDTO);

    List<ProblemDTO> getAll();

    ProblemDTO get(Integer id);

    ApiResult edit(Integer id, ProblemDTO problemDTO);

    ApiResult delete(Integer id);
}
