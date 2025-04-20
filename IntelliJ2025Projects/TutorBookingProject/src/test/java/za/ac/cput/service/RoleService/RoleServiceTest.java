package za.ac.cput.service.RoleService;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Role;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RoleServiceTest {
    @Autowired
    private RoleService roleService;
    private static Role role1;
    private static Role role2;
    private static Role role3;
    @BeforeAll
    static void setUp() {
        role1 = new Role("Tutor");
        role2 = new Role("Student");
        role3 = new Role("Admin");

    }

    @Test
    @Order(1)
    void create() {
        Role createdRole = roleService.create(role1);
        assertNotNull(createdRole);
        System.out.println(createdRole);

        Role createdRole2 = roleService.create(role2);
        assertNotNull(createdRole2);
        System.out.println(createdRole2);

        Role createdRole3 = roleService.create(role3);
        assertNotNull(createdRole3);
        System.out.println(createdRole3);



    }

    @Test
    @Order(2)
    void getAll() {
        System.out.println(roleService.getAll());
    }
}