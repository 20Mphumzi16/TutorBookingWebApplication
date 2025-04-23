package za.ac.cput.service.ExperienceService;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Experience;
import za.ac.cput.factory.ExperienceFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ExperienceServiceTest {
    @Autowired
    private ExperienceService experienceService;
    private static Experience experience1;
    private static Experience experience2;
    private static Experience experience3;

    @BeforeAll
    static void setUp() {
        System.out.println("-------------------------------SETUP-----------------------------");

        experience1 = ExperienceFactory.build("Junior Software Engineer", "Amazon", LocalDate.of(2019, 12, 01), LocalDate.of(2021, 06, 20));
        experience2 = ExperienceFactory.build("Intern Developer", "Datacentrix", LocalDate.of(2018, 07, 17), LocalDate.of(2022, 11, 16));
        experience3 = ExperienceFactory.build("Junior Software Engineer", "Amazon", LocalDate.of(2025, 01, 01), LocalDate.of(2025, 03, 20));
    }

    @Test
    @Order(1)
    void create() {
        System.out.println("-------------------------------CREATE-----------------------------");

        Experience createdExperience = experienceService.create(experience1);
        assertNotNull(createdExperience);
        System.out.println(createdExperience);

        Experience createdExperience2 = experienceService.create(experience2);
        assertNotNull(createdExperience2);
        System.out.println(createdExperience2);

        Experience createdExperience3 = experienceService.create(experience3);
        assertNotNull(createdExperience3);
        System.out.println(createdExperience3);

    }

    @Test
    @Order(2)
    void read() {
        System.out.println("------------------------------READ------------------------------");
        Experience readExperience = experienceService.read(1L);
        assertNotNull(readExperience);
        System.out.println(readExperience);
    }

    @Test
    @Order(3)
    void update() {

        System.out.println("-------------------------------UPDATE-------------------------------");
        Experience updatedExperience = new Experience.ExperienceBuilder().copy(experience1).setCompanyName("Azure").build();


    }

    @Test
    @Order(4)
    void delete() {
        System.out.println("-------------------------------DELETE------------------------------");
        boolean deleted = experienceService.delete(3L);
        assertTrue(deleted);
        System.out.println("Experience deleted");
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("-------------------------------GET ALL------------------------------");
        System.out.println(experienceService.getAll());
    }
}