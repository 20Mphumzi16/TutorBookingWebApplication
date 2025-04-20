package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
