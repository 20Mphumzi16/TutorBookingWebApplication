package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.TutorPreferences;

public interface TutorPreferencesRepository extends JpaRepository<TutorPreferences, Long> {
}
