package uz.pdp.codingbat.payload;

import lombok.Data;

@Data
public class ProblemDTO {
    private Integer id;

    private String title;

    private String description;

    private String method;

    private Integer section_id;

    public ProblemDTO(Integer id, String title, String description, String method, Integer id1) {

    }
}
