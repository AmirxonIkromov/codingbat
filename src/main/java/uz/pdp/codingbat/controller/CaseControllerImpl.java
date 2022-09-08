package uz.pdp.codingbat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.CaseDTO;
import uz.pdp.codingbat.payload.SectionDTO;
import uz.pdp.codingbat.service.LanguageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CaseControllerImpl implements CaseController {

    private final LanguageService languageService;


    @Override
    public ApiResult add(CaseDTO caseDTO) {
        return null;
    }

    @Override
    public List<CaseDTO> getAll() {
        return null;
    }

    @Override
    public CaseDTO get(Short id) {
        return null;
    }

    @Override
    public ApiResult edit(Short id, CaseDTO caseDTO) {
        return null;
    }

    @Override
    public ApiResult delete(Short id) {
        return null;
    }
}
