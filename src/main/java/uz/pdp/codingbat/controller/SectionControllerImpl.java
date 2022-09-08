package uz.pdp.codingbat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SectionDTO;
import uz.pdp.codingbat.service.LanguageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SectionControllerImpl implements SectionController {

    private final LanguageService languageService;


    @Override
    public ApiResult add(SectionDTO sectionDTO) {
        return null;
    }

    @Override
    public List<SectionDTO> getAll() {
        return null;
    }

    @Override
    public SectionDTO get(Short id) {
        return null;
    }

    @Override
    public ApiResult edit(Short id, SectionDTO sectionDTO) {
        return null;
    }

    @Override
    public ApiResult delete(Short id) {
        return null;
    }
}
