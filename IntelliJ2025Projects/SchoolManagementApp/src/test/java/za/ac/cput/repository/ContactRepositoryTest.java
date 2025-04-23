package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactRepositoryTest {

    static ContactRepository repository;
    private static Contact con1;
    private static  Contact con2;

    @BeforeAll
    static void setUp() {

        con1 = ContactFactory.buildContact(1L, "mphumzimbula@gmail.com", "0658436358");

        con2 = ContactFactory.buildContact(2L, "sine@gmail.com", "0658436358");

        repository=new ContactRepository();
    }

    @Test
    @Order(1)
    void create() {

       Contact conTest= repository.create(con1);
        Contact conTest2= repository.create(con2);
        assertEquals(conTest.getId(),con1.getId());
        assertEquals(conTest2.getId(),con2.getId());
        System.out.println(conTest2);

    }

//    @Test
//    @Order(2)
//    void read() {
//    }

    @Test
    @Order(3)
    void update() {
    }

    @Test
    @Order(4)
    void delete() {
    }

    @Test
    @Order(2)
    void getAll() {

        System.out.println( repository.getAll());
    }
}