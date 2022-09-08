package uz.pdp.codingbat.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.LanguageDTO;

import java.util.List;

@RequestMapping("/language")
public interface LanguageController {

    @PostMapping
    ApiResult add(@RequestBody LanguageDTO languageDTO);

    @GetMapping
    List<LanguageDTO> getAll();

    @GetMapping("/{id}")
    LanguageDTO get(@PathVariable Integer id);

    @PutMapping("/{id}")
    ApiResult edit(@PathVariable Integer id,
                   @RequestBody LanguageDTO languageDTO);

    @DeleteMapping("/{id}")
    ApiResult delete(@PathVariable Integer id);


}
