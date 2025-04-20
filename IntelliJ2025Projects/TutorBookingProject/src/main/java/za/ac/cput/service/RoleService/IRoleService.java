package za.ac.cput.service.RoleService;

import za.ac.cput.domain.Role;
import za.ac.cput.repository.RoleRepository;

import java.util.List;

public interface IRoleService {
    Role create(Role role);
    List<Role> getAll();

}
