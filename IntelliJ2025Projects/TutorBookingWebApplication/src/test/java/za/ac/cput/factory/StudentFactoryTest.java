package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Language;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {
    private static Language language1;
    private static Language language2;
    private static List<Language> languages1;
    private static List<Language> languages2;
    private static Student student1;
    private static Student student2;
    private static Student student3;
    private static byte[] image1;
    private static byte[] image2;
    private static Role role1;
    private static Role role2;
    private static Set<Role> roles1;
    private static Set<Role> roles2;

    @BeforeAll
    static void setUp() {
        language1 = new Language.LanguageBuilder().setId(1L).setName("English").build();
        language2 = new Language.LanguageBuilder().setId(2L).setName("French").build();

        languages1 = new ArrayList<>();
        languages1.add(language1);

        languages2 = new ArrayList<>();
        languages2.add(language2);
        languages2.add(language1);

        image1 = new byte[0];
        image2 = new byte[0];



        role1 = new Role(1, "Student");
        role2 = new Role(2, "Student");
        roles1 = new HashSet<>();
        roles1.add(role1);
        roles2 = new HashSet<>();
        roles2.add(role2);


    }

    @Test
    void buildStudent() {
        student1 = StudentFactory.buildStudent(1L, "mphumzi", "mbula", image1, "20Mphmbu16!", "mphumzimbula@gmail.com", "0658436358", roles1, languages1, 2);
        assertNotNull(student1);
        System.out.println(student1);
    }

    @Test
    void testBuildStudent() {

        student2 = StudentFactory.buildStudent(2L, "Vuyokazi","Joy", "Xayiya", image2, "20Vee16!", "veexayiya@gmail.com", "0672582255", roles2, languages2, 1);
        assertNotNull(student2);
        System.out.println(student2);
    }

    @Test
    void testBuildStudentWithInvalidEmail() {
//MustFail
        student3 = StudentFactory.buildStudent(3L, "Toto", "Xayiya", image2, "20Vee16!", "veexayiya@gmail.com", "0172582255", roles2, languages2, 1);
        assertNotNull(student3);
        System.out.println(student3);

    }
}