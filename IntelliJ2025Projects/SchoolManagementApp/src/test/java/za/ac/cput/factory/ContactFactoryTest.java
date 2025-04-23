package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {
   private static  Contact con1;
   private static  Contact con2;

    @BeforeAll
    static void setUp() {
        con1=ContactFactory.buildContact(1L,"mphumzimbula@gmail.com","0658436358");
        con2=ContactFactory.buildContact(-1L,"sine@gmail.com","0658436358");
    }

    @Test
    void buildContact() {
        assertNotNull(con1);
        System.out.println(con1);

    }
    @Test
    void buildContactWithInvalidIdMustFail() {
        assertNotNull(con2);
        System.out.println(con2);
    }
}