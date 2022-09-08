package uz.pdp.codingbat.payload;

import lombok.Data;

@Data
public class CaseDTO {
    private Integer id;

    private String args;

    private String expected;

    private Integer problem_id;

    public CaseDTO(Long id, String expected, String args, Integer id1) {

    }
}
