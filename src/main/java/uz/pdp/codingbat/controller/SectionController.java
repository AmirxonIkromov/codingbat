package uz.pdp.codingbat.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SectionDTO;

import java.util.List;

@RequestMapping("/section")
public interface SectionController {

    @PostMapping
    ApiResult add(@RequestBody SectionDTO sectionDTO);

    @GetMapping
    List<SectionDTO> getAll();

    @GetMapping("/{id}")
    SectionDTO get(@PathVariable Short id);

    @PutMapping("/{id}")
    ApiResult edit(@PathVariable Short id,
                   @RequestBody SectionDTO sectionDTO);

    @DeleteMapping("/{id}")
    ApiResult delete(@PathVariable Short id);


}
