package uz.pdp.codingbat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.LanguageDTO;
import uz.pdp.codingbat.service.LanguageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LanguageControllerImpl implements LanguageController {

    private final LanguageService languageService;

    @Override
    public ApiResult add(LanguageDTO languageDTO) {
        return languageService.add(languageDTO);
    }



    @Override
    public List<LanguageDTO> getAll() {
        return languageService.getAll();
    }

    @Override
    public LanguageDTO get(Integer id) {
        return languageService.get(id);
    }

    @Override
    public ApiResult edit(Integer id, LanguageDTO languageDTO) {
        return languageService.edit(id,languageDTO);
    }

    @Override
    public ApiResult delete(Integer id) {
        return languageService.delete(id);
    }
}
