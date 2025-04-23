package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
