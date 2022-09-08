package uz.pdp.codingbat.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.ProblemDTO;

import java.util.List;

@RequestMapping("/problem")
public interface ProblemController {

    @PostMapping
    ApiResult add(@RequestBody ProblemDTO problemDTO);

    @GetMapping
    List<ProblemDTO> getAll();

    @GetMapping("/{id}")
    ProblemDTO get(@PathVariable Short id);

    @PutMapping("/{id}")
    ApiResult edit(@PathVariable Short id,
                   @RequestBody ProblemDTO problemDTO);

    @DeleteMapping("/{id}")
    ApiResult delete(@PathVariable Short id);


}
