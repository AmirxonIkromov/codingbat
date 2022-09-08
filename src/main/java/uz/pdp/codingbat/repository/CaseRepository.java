package uz.pdp.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.codingbat.entity.Case;

public interface CaseRepository extends JpaRepository<Case,Integer> {
}
