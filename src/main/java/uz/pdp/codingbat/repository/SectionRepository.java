package uz.pdp.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.codingbat.entity.Section;

public interface SectionRepository extends JpaRepository<Section,Integer> {
}
