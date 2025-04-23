package za.ac.cput.service.TutorPreferenceService;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.TutorPreferences;
import za.ac.cput.factory.TutorPreferencesFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TutorPreferencesServiceTest {
    @Autowired
    private TutorPreferencesService tutorPreferencesService;
    private static TutorPreferences tutorPreferences1;
    private static TutorPreferences tutorPreferences2;
    private static TutorPreferences tutorPreferences3;

    @BeforeAll
    static void setUp() {
        System.out.println("-------------------------SETUP------------------------------");

        tutorPreferences1 = TutorPreferencesFactory.buildTutorPreferences(true,true,true,true,50.00,100.00);
        tutorPreferences2=TutorPreferencesFactory.buildTutorPreferences(false,true,false,true,0.00,100.00);
        tutorPreferences3=TutorPreferencesFactory.buildTutorPreferences(false,true,false,true,20.00,100.00);
    }


    @Test
    @Order(1)
    void create() {
        System.out.println("-------------------------CREATE------------------------------");

        TutorPreferences createdTutorPreferences = tutorPreferencesService.create(tutorPreferences1);
        assertNotNull(createdTutorPreferences);
        System.out.println(createdTutorPreferences);

        TutorPreferences createdTutorPreferences2 = tutorPreferencesService.create(tutorPreferences2);
        assertNotNull(createdTutorPreferences2);
        System.out.println(createdTutorPreferences2);

        TutorPreferences createdTutorPreferences3 = tutorPreferencesService.create(tutorPreferences3);
        assertNotNull(createdTutorPreferences3);
        System.out.println(createdTutorPreferences3);

    }

    @Test
    @Order(2)
    void read() {
        System.out.println("--------------------------READ-------------------------------");

        TutorPreferences readTutorPreferences=tutorPreferencesService.read(1L);
        assertNotNull(readTutorPreferences);
        System.out.println(readTutorPreferences);

    }

    @Test
    @Order(3)
    void update() {
        System.out.println("-------------------------UPDATE-------------------------------");

        TutorPreferences TutorPreferencesToUpdate = new TutorPreferences.TutorPreferencesBuilder().copy(tutorPreferences1).setCanTravel(false).setMaxFee(500.00).build();
        TutorPreferences updatedTutorPreferences = tutorPreferencesService.update(TutorPreferencesToUpdate);
        assertNotNull(updatedTutorPreferences);
        System.out.println(updatedTutorPreferences);

    }

    @Test
    @Order(4)
    void delete() {
        System.out.println("---------------------------DELETE-----------------------------");
        boolean delete=tutorPreferencesService.delete(3L);
        assertTrue(delete);
        System.out.println("Deleted tutor preferences");
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("-------------------------GET ALL------------------------------");
        System.out.println(tutorPreferencesService.getAll());
    }
}