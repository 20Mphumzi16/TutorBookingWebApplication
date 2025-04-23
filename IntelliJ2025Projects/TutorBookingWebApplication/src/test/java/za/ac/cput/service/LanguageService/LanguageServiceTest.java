package za.ac.cput.service.LanguageService;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Language;
import za.ac.cput.factory.LanguageFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LanguageServiceTest {
    @Autowired
    private LanguageService languageService;
    private static Language language1;
    private static Language language2;
    private static Language language3;


    @BeforeAll
    static void setUp() {

        System.out.println("-------------------------SETUP------------------------------");

        language1 = LanguageFactory.buildLanguage("English");
        language2 = LanguageFactory.buildLanguage("French");
        language3 = LanguageFactory.buildLanguage("Spanish");
    }

    @Test
    @Order(1)
    void create() {
        System.out.println("-------------------------CREATE------------------------------");

        languageService.create(language1);
        assertNotNull(language1);
        System.out.println(language1);

        languageService.create(language2);
        assertNotNull(language2);
        System.out.println(language2);

        languageService.create(language3);
        assertNotNull(language3);
        System.out.println(language3);
    }

    @Test
    @Order(2)
    void read() {

        System.out.println("-------------------------READ------------------------------");

        Language readLanguage=languageService.read(1L);
        assertNotNull(readLanguage);
        System.out.println(readLanguage);
    }

    @Test
    @Order(3)
    void update() {

        System.out.println("-------------------------UPDATE------------------------------");

        Language languageToUpdate=new Language.LanguageBuilder().copy(language1).setName("Xhosa").build();
        Language updatedLanguage=languageService.update(languageToUpdate);
        assertNotNull(updatedLanguage);
        System.out.println(updatedLanguage);
    }

    @Test
    @Order(4)
    void delete() {
        System.out.println("-------------------------DELETE-----------------------------");

        boolean isDeleted=languageService.delete(3L);
        assertTrue(isDeleted);
        System.out.println("Language"+ language3.getName()+" with Id"+" "+language3.getId()+" deleted successfully");
    }

    @Test
    @Order(5)
    void getAll() {

        System.out.println("-------------------------GET ALL--------------------------");

        List<Language> allLanguages=languageService.getAll();
        System.out.println(allLanguages);
    }
}