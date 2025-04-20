package za.ac.cput.service.SubjectService;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Subject;
import za.ac.cput.factory.SubjectFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SubjectServiceTest {
    @Autowired
    private SubjectService subjectService;
    private static Subject subject1;
    private static Subject subject2;
    private static Subject subject3;


    @BeforeAll
    static void setUp() {
        System.out.println("-------------------------SETUP------------------------------");

        subject1 = SubjectFactory.buildSubject("Java");
        subject2 =SubjectFactory.buildSubject("Python");
        subject3 =SubjectFactory.buildSubject("C++");

    }

    @Test
    @Order(1)
    void create() {
        System.out.println("-------------------------CREATE------------------------------");

        Subject createdSubject= subjectService.create(subject1);
        assertNotNull(createdSubject);
        System.out.println(createdSubject);

        Subject createdSubject2= subjectService.create(subject2);
        assertNotNull(createdSubject2);
        System.out.println(createdSubject2);

        Subject createdSubject3= subjectService.create(subject3);
        assertNotNull(createdSubject3);
        System.out.println(createdSubject3);

    }

    @Test
    @Order(2)
    void read() {
        System.out.println("-------------------------READ-------------------------------");

        Subject readSubject= subjectService.read(1L);
        assertNotNull(readSubject);
        System.out.println(readSubject);

    }

    @Test
    @Order(3)
    void update() {

        System.out.println("------------------------UPDATE-------------------------------");

        Subject subjectToUpdate= new Subject.SubjectBuilder().copy(subject1).setName("Assembly").build();
        Subject updatedSubject= subjectService.update(subjectToUpdate);
        assertNotNull(updatedSubject);
        System.out.println(updatedSubject);
    }

    @Test
    @Order(4)
    void delete() {
        System.out.println("-------------------------DELETE-------------------------------");

        boolean deleted = subjectService.delete(3L);
        assertTrue(deleted);
        System.out.println("Subject with Id "+3+ "Is deleted successfully");
    }

    @Test
    void getAll() {
        System.out.println("--------------------------GET-ALL-----------------------------");
        System.out.println(subjectService.getAll());
    }
}