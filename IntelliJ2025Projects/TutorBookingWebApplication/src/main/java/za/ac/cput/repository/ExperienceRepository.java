package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
