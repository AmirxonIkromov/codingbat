package uz.pdp.codingbat.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.CaseDTO;
import uz.pdp.codingbat.payload.LanguageDTO;

import java.util.List;

@RequestMapping("/case")
public interface CaseController {

    @PostMapping
    ApiResult add(@RequestBody CaseDTO caseDTO);

    @GetMapping
    List<CaseDTO> getAll();

    @GetMapping("/{id}")
    CaseDTO get(@PathVariable Short id);

    @PutMapping("/{id}")
    ApiResult edit(@PathVariable Short id,
                   @RequestBody CaseDTO caseDTO);

    @DeleteMapping("/{id}")
    ApiResult delete(@PathVariable Short id);


}
