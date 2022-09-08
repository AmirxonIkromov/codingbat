package uz.pdp.codingbat.service;

import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.LanguageDTO;

import java.util.List;

public interface LanguageService {

    ApiResult add(LanguageDTO languageDTO);

    List<LanguageDTO> getAll();

    LanguageDTO get(Integer id);

    ApiResult edit(Integer id, LanguageDTO languageDTO);

    ApiResult delete(Integer id);
}
