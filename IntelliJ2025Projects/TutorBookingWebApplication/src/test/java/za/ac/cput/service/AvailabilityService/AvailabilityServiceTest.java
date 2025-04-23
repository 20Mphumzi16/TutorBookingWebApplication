package za.ac.cput.service.AvailabilityService;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.LanguageService.LanguageService;
import za.ac.cput.service.TutorService.TutorService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AvailabilityServiceTest {
    @Autowired
    private AvailabilityService availabilityService;
    private static Availability availability1;
    private static Availability availability2;
    private static Availability availability3;
    private static Language language1;
    private static Language language2;
    private static Language language3;
    private static List<Language> languages1;
    private static List<Language> languages2;
    private static List<Language> languages3;
    private static Tutor tutor1;
    private static Tutor tutor2;
    private static Tutor tutor3;
    private static byte[] image1;
    private static byte[] image2;
    private static byte[] image3;
    private static Role role1;
    ;
    private static Set<Role> roles1;
    private static Education education1;
    private static Education education2;
    private static Education education3;
    private static List<Education> educationList1;
    private static List<Education> educationList2;
    private static List<Education> educationList3;
    private static Experience experience1;
    private static Experience experience2;
    private static Experience experience3;
    private static List<Experience> jobExperience1;
    private static List<Experience> jobExperience2;
    private static List<Experience> jobExperience3;
    private static TutorPreferences tutorPreferences1;
    private static TutorPreferences tutorPreferences2;
    private static TutorPreferences tutorPreferences3;


    @BeforeAll
    static void setUp(@Autowired LanguageService languageService, @Autowired TutorService tutorService) {

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


        role1 = new Role(1, "Tutor");


        roles1 = new HashSet<>();
        roles1.add(role1);

        //Education
        education1 = EducationFactory.build("UWC", "Computer Science", LocalDate.of(2022, 01, 01), LocalDate.of(2024, 12, 31));
        educationList1 = new ArrayList<>();
        educationList1.add(education1);

        education2 = EducationFactory.build("CPUT", "IT", LocalDate.of(2019, 01, 01), LocalDate.of(2020, 12, 31));
        educationList2 = new ArrayList<>();
        educationList2.add(education2);

        education3 = EducationFactory.build("UCT", "Computer Science", LocalDate.of(2022, 01, 01), LocalDate.of(2025, 01, 31));
        educationList3 = new ArrayList<>();
        educationList3.add(education3);

        //Experience
        experience1 = ExperienceFactory.build("Junior Software Engineer", "Amazon", LocalDate.of(2019, 12, 01), LocalDate.of(2021, 06, 20));
        jobExperience1 = new ArrayList<>();
        jobExperience1.add(experience1);

        experience2 = ExperienceFactory.build("Intern Developer", "Datacentrix", LocalDate.of(2018, 07, 17), LocalDate.of(2022, 11, 16));
        jobExperience2 = new ArrayList<>();
        jobExperience2.add(experience2);

        experience3 = ExperienceFactory.build("CTO", "Absa", LocalDate.of(2019, 07, 17), LocalDate.of(2022, 8, 23));
        jobExperience3 = new ArrayList<>();
        jobExperience3.add(experience3);

        //Tutor Preferences
        tutorPreferences1 = TutorPreferencesFactory.buildTutorPreferences(true, true, true, true, 50.00, 100.00);
        tutorPreferences2 = TutorPreferencesFactory.buildTutorPreferences(false, true, false, true, 0.00, 100.00);
        tutorPreferences3 = TutorPreferencesFactory.buildTutorPreferences(false, true, false, true, 0.00, 100.00);

        tutor1 = TutorFactory.buildTutor("Mpumzi", "Mbula", image1, "20Mphmbu16!", "mphumzimbula@gmail.com", "0658436358", roles1, languages1, "Experienced Computer Science  Lecturer", 2, 1, jobExperience1, educationList1, tutorPreferences1);
        tutorService.create(tutor1);

        tutor2 = TutorFactory.buildTutor("Vuyokazi", "Joy", "Xayiya", image2, "20VeeXayiya16!", "vjxayiya@gmail.com", "0735805117", roles1, languages2, "Tenured Educator who is in the tech space", 5, 2, jobExperience2, educationList2, tutorPreferences2);
        tutorService.create(tutor2);

        tutor3 = TutorFactory.buildTutor("Toto", "Mgaiva", "Xayiya", image3, "20VeeXayiya16!", "totoxayiya@gmail.com", "0677777777", roles1, languages3, "Exceptional Lecturer", 3, 4, jobExperience3, educationList3, tutorPreferences3);
        tutorService.create(tutor3);

        availability1 = AvailabilityFactory.buildAvailability(LocalDate.now(), LocalTime.of(22, 00), LocalTime.of(23, 00), tutor1, true);
        availability2 = AvailabilityFactory.buildAvailability(LocalDate.now(), LocalTime.of(20, 00), LocalTime.of(22, 00), tutor2, false);
        availability3 = AvailabilityFactory.buildAvailability(LocalDate.now(), LocalTime.of(18, 00), LocalTime.of(20, 00), tutor2, false);
    }

    @Test
    @Order(1)
    void create() {
        System.out.println("------------------------------CREATE-------------------------");

        Availability createdAvailability1 = availabilityService.create(availability1);
        assertNotNull(createdAvailability1);
        System.out.println(createdAvailability1);

        Availability createdAvailability2 = availabilityService.create(availability2);
        assertNotNull(createdAvailability2);
        System.out.println(createdAvailability2);

        Availability createdAvailability3 = availabilityService.create(availability3);
        assertNotNull(createdAvailability3);
        System.out.println(createdAvailability3);


    }

    @Test
    @Order(2)
    void read() {
        System.out.println("---------------------------------READ---------------------------");
        Availability readAvailability = availabilityService.read(1L);
        assertNotNull(readAvailability);
        System.out.println(readAvailability);
    }

    @Test
    @Order(3)
    void update() {
        System.out.println("-------------------------UPDATE---------------------------");
        Availability availabilityToUpdate = new Availability.AvailabilityBuilder().copy(availability2).setBooked(true).build();
        Availability availabilityUpdated = availabilityService.update(availabilityToUpdate);
        assertNotNull(availabilityUpdated);
        System.out.println(availabilityUpdated);
    }

    @Test
    @Order(4)
    void delete() {
        System.out.println("------------------------Delete-------------------------");

        boolean isDeleted= availabilityService.delete(3L);
        assertTrue(isDeleted);
        System.out.println("Availability Deleted Successfully");
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("-----------------------------GETALL--------------------------");
        System.out.println(availabilityService.getAll());
    }
}