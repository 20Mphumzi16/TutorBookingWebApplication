package za.ac.cput.service.EducationService;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Education;
import za.ac.cput.factory.EducationFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EducationServiceTest {

    @Autowired
    private EducationService educationService;

    private static Education education1;
    private static Education education2;
    private static Education education3;

    @BeforeAll
    static void setUp() {
        System.out.println("-------------------------------SETUP-----------------------------");

        education1 = EducationFactory.build("UWC", "Computer Science", LocalDate.of(2022, 01, 01), LocalDate.of(2024, 12, 31));
        education2 = EducationFactory.build( "CPUT", "IT", LocalDate.of(2019, 01, 01), LocalDate.of(2020, 12, 31));
        education3 = EducationFactory.build( "UCT", "HC ICT", LocalDate.of(2021, 01, 01), LocalDate.of(2021, 12, 31));

    }

    @Test
    @Order(1)
    void create() {
        System.out.println("-------------------------------CREATE-----------------------------");

        educationService.create(education1);
        assertNotNull(education1);
        System.out.println(education1);

        educationService.create(education2);
        assertNotNull(education2);
        System.out.println(education2);

        educationService.create(education3);
        assertNotNull(education3);
        System.out.println(education3);
    }

    @Test
    @Order(2)
    void read() {
        System.out.println("---------------------------------READ------------------------------");

       Education readEducation= educationService.read(1L);
        assertNotNull(readEducation);
        System.out.println(readEducation);
    }

    @Test
    @Order(3)
    void update() {
        System.out.println("------------------------------UPDATE------------------------------");

        Education educationToUpdate = new Education.EducationBuilder().copy(education1).setQualificationName("D ICT").build();
        Education updatedEducation = educationService.update(educationToUpdate);
        assertNotNull(updatedEducation);
        System.out.println(updatedEducation);
    }

    @Test
    @Order(4)
    void delete() {
        System.out.println("-------------------------------DELETE-----------------------------");

        boolean isDeleted = educationService.delete(3L);
        assertTrue(isDeleted);
        System.out.println("Education with ID" + 3L + " deleted successfully");
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("---------------------------------GET-ALL--------------------------");
        System.out.println(educationService.getAll());
    }
}