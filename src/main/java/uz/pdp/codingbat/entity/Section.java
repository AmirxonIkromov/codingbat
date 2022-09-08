package uz.pdp.codingbat.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"title", "language_id"}),
        @UniqueConstraint(columnNames = {"url", "language_id"})
})
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Integer maxRate;

    @Column(nullable = false,columnDefinition = "text")
    private String description;

    @ManyToOne(optional = false)
    private Language language;
}
