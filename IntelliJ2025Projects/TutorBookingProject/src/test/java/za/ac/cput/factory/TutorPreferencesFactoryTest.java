package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.TutorPreferences;

import static org.junit.jupiter.api.Assertions.*;

class TutorPreferencesFactoryTest {
    private static TutorPreferences tutorPreferences1;
    private static TutorPreferences tutorPreferences2;
    private static TutorPreferences tutorPreferences3;

    @BeforeAll
    static void setUp() {
        tutorPreferences1 = TutorPreferencesFactory.buildTutorPreferences(1L,true,true,true,true,50.00,100.00);
        tutorPreferences2=TutorPreferencesFactory.buildTutorPreferences(2L,false,true,false,true,0.00,100.00);
        tutorPreferences3=TutorPreferencesFactory.buildTutorPreferences(3L,false,true,false,true,-1.00,100.00);
    }

    @Test
    void buildTutorPreferences() {
        assertNotNull(tutorPreferences1);
        System.out.println(tutorPreferences1);

        assertNotNull(tutorPreferences2);
        System.out.println(tutorPreferences2);
    }
    @Test
    void buildTutorPreferencesWithInvalidPriceMustBeNull() {
        assertNull(tutorPreferences3);
        System.out.println(tutorPreferences3);

    }
}