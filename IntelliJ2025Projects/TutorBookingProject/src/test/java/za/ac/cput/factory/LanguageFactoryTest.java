package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Language;

import static org.junit.jupiter.api.Assertions.*;

class LanguageFactoryTest {
private  static Language language1;
private  static Language language2;
private  static Language language3;
    @BeforeAll
    static void setUp() {
        language1=LanguageFactory.buildLanguage(1L,"English");
        language2=LanguageFactory.buildLanguage(0L,"French");
        language3=LanguageFactory.buildLanguage(3L,"");
    }

    @Test
    void buildLanguage() {
        assertNotNull(language1);
        System.out.println(language1);
    }

    @Test
    void buildLanguageWithInvalidIdMustFail() {
        assertNotNull(language2);
        System.out.println(language2);
    }

    @Test
    void buildLanguageWithEmptyName() {
        assertNotNull(language3);
        System.out.println(language3);


    }
}