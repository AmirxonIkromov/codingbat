package uz.pdp.codingbat.entity;


import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Data
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true)
    private String url;

    public Language(String title) {


    }
}
