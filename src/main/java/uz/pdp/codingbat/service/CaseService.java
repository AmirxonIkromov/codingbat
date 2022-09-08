package uz.pdp.codingbat.service;

import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.CaseDTO;

import java.util.List;

public interface CaseService {

    ApiResult add(CaseDTO caseDTO);

    List<CaseDTO> getAll();

    CaseDTO get(Integer id);

    ApiResult edit(Integer id, CaseDTO caseDTO);

    ApiResult delete(Integer id);
}
