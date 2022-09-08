package uz.pdp.codingbat.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SectionDTO {
    private Integer id;

    private String title;

    private String url;

    private Integer maxRate;

    private String description;

    private Integer language_id;

    public SectionDTO(Integer id, String title, String url, Integer id1, Integer maxRate, String description) {

    }

}
