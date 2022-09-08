package uz.pdp.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.codingbat.entity.Language;

import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language,Short> {
    Optional<Language> findById(Integer id);

    boolean existsByTitle(String title);

}
