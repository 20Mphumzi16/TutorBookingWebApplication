package za.ac.cput.service.StudentService;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Language;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.LanguageFactory;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.service.LanguageService.LanguageService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentServiceTest {


    @Autowired
    private StudentService studentService;

    private static Language language1;
    private static Language language2;
    private static Language language3;
    private static List<Language> languages1;
    private static List<Language> languages2;
    private static List<Language> languages3;
    private static Student student1;
    private static Student student2;
    private static Student student3;
    private static byte[] image1;
    private static byte[] image2;
    private static byte[] image3;
    private static Role role1;
    private static Role role2;
    private static Role role3;
    private static Set<Role> roles1;
    private static Set<Role> roles2;
    private static Set<Role> roles3;

    @BeforeAll
    static void setUp( @Autowired LanguageService languageService) {
        System.out.println("-------------------------SETUP------------------------------");
        language1 = languageService.create(LanguageFactory.buildLanguage("English"));
        language2 = languageService.create(LanguageFactory.buildLanguage("Spanish"));
        language3 = languageService.create(LanguageFactory.buildLanguage("French"));


        languages1 = new ArrayList<>();
        languages1.add(language1);

        languages2 = new ArrayList<>();
        languages2.add(language2);


        languages3 = new ArrayList<>();
        languages3.add(language3);


        image1 = new byte[0];
        image2 = new byte[0];
        image3 = new byte[0];


        role1 = new Role(1, "Student");
        role2 = new Role(1, "Student");
        role3 = new Role(1, "Student");

        roles1 = new HashSet<>();
        roles1.add(role1);
        roles2 = new HashSet<>();
        roles2.add(role2);
        roles3 = new HashSet<>();
        roles3.add(role3);

        student1 = StudentFactory.buildStudent( "mphumzi", "mbula", image1, "20Mphmbu16!", "mphumzimbula@gmail.com", "0658436358", roles1, languages1, 2);
        student2 = StudentFactory.buildStudent( "Vuyokazi","Joy", "Xayiya", image2, "20Vee16!", "veexayiya@gmail.com", "0672582255", roles2, languages2, 1);
        student3 = StudentFactory.buildStudent("Toto", "Xayiya", image3, "20Vee16!", "veexayiya27@gmail.com", "0172582255", roles3, languages3, 3);

    }

    @Test
    @Order(1)
    void create() {
        System.out.println("-------------------------CREATE------------------------------");

        Student createdStudent = studentService.create(student1);
        assertNotNull(createdStudent);
        System.out.println(createdStudent);

        Student createdStudent2 = studentService.create(student2);
        assertNotNull(createdStudent2);
        System.out.println(createdStudent2);

        Student createdStudent3 = studentService.create(student3);
        assertNotNull(createdStudent3);
        System.out.println(createdStudent3);




    }

    @Test
    @Order(2)
    void read() {
        System.out.println("--------------------------READ-------------------------------");
        Student readStudent = studentService.read(1L);
        assertNotNull(readStudent);
        System.out.println(readStudent);
    }

    @Test
    @Order(3)
    void update() {
        System.out.println("--------------------------UPDATE------------------------------");
        Student studentToUpDate=new Student.StudentBuilder().copy(student1).setYearOfStudy(7).build();
        Student updatedStudent=studentService.update(studentToUpDate);
        assertNotNull(updatedStudent);
        System.out.println(updatedStudent);
    }

    @Test
    @Order(4)
    void delete() {
        System.out.println("---------------------------DELETE-------------------------------");
        boolean deleted =studentService.delete(3L);
        assertTrue(deleted);
        System.out.println("Student Deleted Successfully");
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("----------------------------GET ALL---------------------------");
        System.out.println(studentService.getAll());
    }
}