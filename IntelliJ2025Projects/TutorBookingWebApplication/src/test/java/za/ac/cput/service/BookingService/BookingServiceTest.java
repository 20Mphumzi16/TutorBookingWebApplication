package za.ac.cput.service.BookingService;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.LanguageService.LanguageService;
import za.ac.cput.service.StudentService.StudentService;
import za.ac.cput.service.SubjectService.SubjectService;
import za.ac.cput.service.TutorService.TutorService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingServiceTest {
    @Autowired
    private BookingService bookingService;
    private static Booking booking1;
    private static Booking booking2;
    private static Booking booking3;
    private static Language language1;
    private static Language language2;
    private static Language language3;
    private static List<Language> languages1;
    private static List<Language> languages2;
    private static List<Language> languages3;
    private static Tutor tutor1;
    private static Tutor tutor2;
    private static Tutor tutor3;
    private static Student student1;
    private static Student student2;
    private static Student student3;
    private static byte[] image1;
    private static byte[] image2;
    private static byte[] image3;
    private static Role role1;
    private static Role role2;
    private static Set<Role> roles1;
    private static Set<Role> roles2;
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
    private static Subject subject1;
    private static Subject subject2;
    private static List<Subject> subjectList1;
    private static List<Subject> subjectList2;


    @BeforeAll
    static void setUp(@Autowired LanguageService languageService, @Autowired TutorService tutorService, @Autowired StudentService studentService, @Autowired SubjectService subjectService) {
        System.out.println("-------------------------------------SETUP--------------------------------------");
//Language
        language1 = languageService.create(LanguageFactory.buildLanguage("English"));
        language2 = languageService.create(LanguageFactory.buildLanguage("Spanish"));
        language3 = languageService.create(LanguageFactory.buildLanguage("French"));


        languages1 = new ArrayList<>();
        languages1.add(language1);

        languages2 = new ArrayList<>();
        languages2.add(language2);


        languages3 = new ArrayList<>();
        languages3.add(language3);

//Images

        image1 = new byte[0];
        image2 = new byte[0];
        image3 = new byte[0];
//Roles

        role1 = new Role(1, "Tutor");
        roles1 = new HashSet<>();
        roles1.add(role1);

        role2 = new Role(2, "Student");
        roles2 = new HashSet<>();
        roles2.add(role2);//Education

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

        subjectList1 = new ArrayList<>();
        subject1 = SubjectFactory.buildSubject( "Java");
        subjectService.create(subject1);
        subjectList1.add(subject1);

        subject2 = SubjectFactory.buildSubject( "Python");
        subjectService.create(subject2);
        subjectList2 = new ArrayList<>();
        subjectList2.add(subject2);

        student1 = StudentFactory.buildStudent("mphumzi", "mbula", image1, "20Mphmbu16!", "mphumzimbula@gmail.com", "0658436358", roles2, languages1, 2);
        studentService.create(student1);
        System.out.println(student1);

        student2 = StudentFactory.buildStudent("Vuyokazi", "Joy", "Xayiya", image2, "20Vee16!", "veexayiya@gmail.com", "0672582255", roles2, languages2, 1);
        studentService.create(student2);
        System.out.println(student2);

        student3 = StudentFactory.buildStudent("Toto", "Xayiya", image3, "20Vee16!", "veexayiya27@gmail.com", "0172582255", roles2, languages3, 3);
        studentService.create(student3);

        System.out.println(student3);

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


        booking1 = BookingFactory.build(LocalDateTime.now(), LocalDate.now(), LocalTime.now().plusHours(2), LocalTime.now().plusHours(4), tutor1, student1, BookingMode.ON_CAMPUS, 2.00, subjectList2, languages1, "Please also assist on my Home work", BookingStatus.PENDING);
        System.out.println(booking1);

        booking2=BookingFactory.build(LocalDateTime.now(),LocalDate.now(),LocalTime.now().plusHours(3),LocalTime.now().plusHours(4),tutor1,student2,BookingMode.ON_CAMPUS,2.00,subjectList2,languages1,"Ngiyashwa yi coding", BookingStatus.PENDING);
        System.out.println(booking2);

        booking3=BookingFactory.build(LocalDateTime.now(),LocalDate.now(),LocalTime.now().plusHours(5),LocalTime.now().plusHours(6),tutor1,student3,BookingMode.ONLINE,2.00,subjectList1,languages1,"PLesase help with data structures and Algorithms",BookingStatus.PENDING);
        System.out.println(booking3);
    }

    @Test
@Order(1)
    void create() {
        System.out.println("-------------------------------------CREATE--------------------------------------");

        Booking createdBooking = bookingService.create(booking1);
        assertNotNull(createdBooking);
        System.out.println(createdBooking);

        Booking createdBooking2 = bookingService.create(booking2);
        assertNotNull(createdBooking2);
        System.out.println(createdBooking2);

        Booking createdBooking3 = bookingService.create(booking3);
        assertNotNull(createdBooking3);
        System.out.println(createdBooking3);

    }

    @Test
    @Order(2)
    void read() {
        System.out.println("-------------------------------------READ--------------------------------------");

        Booking readBooking =bookingService.read(1L);
        assertNotNull(readBooking);
        System.out.println(readBooking);
    }

    @Test
    @Order(3)
    void update() {
        System.out.println("-------------------------------------UPDATE--------------------------------------");

        Booking bookingToUpdate=new Booking.BookingBuilder().copy(booking2).setStatus(BookingStatus.CONFIRMED).build();
        Booking updatedBooking=bookingService.update(bookingToUpdate);
        assertNotNull(updatedBooking);
        System.out.println(updatedBooking);
    }

    @Test
    @Order(4)
    void delete() {
        System.out.println("-------------------------------------DELETE--------------------------------------");

        boolean isDeleted=bookingService.delete(3L);
        assertTrue(isDeleted);
        System.out.println("booking is Deleted Successfully");
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("-------------------------------------GETALL--------------------------------------");
        System.out.println(bookingService.getAll());
    }
    }