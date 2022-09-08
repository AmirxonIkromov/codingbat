package uz.pdp.codingbat.service;

import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SectionDTO;

import java.util.List;

public interface SectionService {

    ApiResult add(SectionDTO sectionDTO);

    List<SectionDTO> getAll();

    SectionDTO get(Integer id);

    ApiResult edit(Integer id, SectionDTO sectionDTO);

    ApiResult delete(Integer id);
}
