package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Education;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
