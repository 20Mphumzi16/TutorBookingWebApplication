package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TutorFactoryTest {
    private static Language language1;
    private static Language language2;
    private static List<Language> languages1;
    private static List<Language> languages2;
    private static Tutor tutor1;
    private static Tutor tutor2;
    private static Tutor tutor3;
    private static byte[] image1;
    private static byte[] image2;
    private static Role role1;
    private static Role role2;
    private static Set<Role> roles1;
    private static Set<Role> roles2;
    private static Education education1;
    private static Education education2;
    private static List<Education> educationList1;
    private static List<Education> educationList2;
    private static Experience experience1;
    private static Experience experience2;
    private static List<Experience> jobExperience1;
    private static List<Experience> jobExperience2;
    private static TutorPreferences tutorPreferences1;
    private static TutorPreferences tutorPreferences2;
    private static Name name1;
    private static Name name2;


    @BeforeEach
    void setUp() {

//Languages

        language1 = new Language.LanguageBuilder().setId(1L).setName("English").build();
        language2 = new Language.LanguageBuilder().setId(2L).setName("French").build();

        languages1 = new ArrayList<>();
        languages1.add(language1);

        languages2 = new ArrayList<>();
        languages2.add(language2);
        languages2.add(language1);

//Images
        image1 = new byte[0];
        image2 = new byte[0];

//Roles
        role1 = new Role(1, "Student");
        role2 = new Role(2, "Student");
        roles1 = new HashSet<>();
        roles1.add(role1);
        roles2 = new HashSet<>();
        roles2.add(role2);

//Names
        name1 = new Name.NameBuilder().setFirstName("Mpumzi").setLastName("Mbula").build();
        name2 = new Name.NameBuilder().setFirstName("Vuyokazi").setPreferredName("Joy").setLastName("Xayiya").build();

        //Education
        education1 = EducationFactory.build(1L, "UWC", "Computer Science", LocalDate.of(2022, 01, 01), LocalDate.of(2024, 12, 31));
        educationList1 = new ArrayList<>();
        educationList1.add(education1);

        education2 = EducationFactory.build(2L, "CPUT", "IT", LocalDate.of(2019, 01, 01), LocalDate.of(2020, 12, 31));
        educationList2 = new ArrayList<>();
        educationList2.add(education2);

        //Experience
        experience1 = ExperienceFactory.build(1L, "Junior Software Engineer", "Amazon", LocalDate.of(2019, 12, 01), LocalDate.of(2021, 06, 20));
        jobExperience1 = new ArrayList<>();
        jobExperience1.add(experience1);

        experience2 = ExperienceFactory.build(2L, "Intern Developer", "Datacentrix", LocalDate.of(2018, 07, 17), LocalDate.of(2022, 11, 16));
        jobExperience2 = new ArrayList<>();
        jobExperience2.add(experience2);

        //Tutor Preferences
        tutorPreferences1 = TutorPreferencesFactory.buildTutorPreferences(1L, true, true, true, true, 50.00, 100.00);
        tutorPreferences2 = TutorPreferencesFactory.buildTutorPreferences(2L, false, true, false, true, 0.00, 100.00);

        tutor1 = TutorFactory.buildTutor(1L, "Mpumzi", "Mbula", image1, "20Mphmbu16!", "mphumzimbula@gmail.com", "0658436358", roles1, languages1, "Experienced Computer Science  Lecturer", 2, 1, jobExperience1, educationList1, tutorPreferences1);
        tutor2 = TutorFactory.buildTutor(2L, "Vuyokazi", "Joy", "Xayiya", image2, "20VeeXayiya16!", "vjxayiya@gmail.com", "0735805117", roles2, languages2, "Tenured Educator who is in the tech space", 5, 2, jobExperience2, educationList2, tutorPreferences2);
        tutor3 = TutorFactory.buildTutor(2L, "Vuyokazi", "Joy", "Xayiya", image2, "20VeeXayiya16!", "vjxayiya@gmail.com", "073587", roles2, languages2, "Tenured Educator who is in the tech space", 5, 2, jobExperience2, educationList2, tutorPreferences2);
    }


    @Test
    void buildTutor() {
        assertNotNull(tutor1);
        System.out.println(tutor1);
        assertNotNull(tutor2);
        System.out.println("=============================");
        System.out.println(tutor2);
    }

    @Test
    void testBuildTutorWithInvalidPhone() {
        assertNotNull(tutor3);
        System.out.println(tutor3);
    }
}