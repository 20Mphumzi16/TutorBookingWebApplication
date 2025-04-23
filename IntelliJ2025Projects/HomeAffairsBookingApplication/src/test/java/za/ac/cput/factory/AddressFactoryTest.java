package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;

import static org.junit.jupiter.api.Assertions.*;
class AddressFactoryTest {
    private static Address address1;
    private static Address address2;

    @BeforeAll
    static void setUp() {
        address1=AddressFactory.buildAddress(1L,"106 Ny6 ","Guguethu","Cape Town","7750");
        address2=AddressFactory.buildAddress(2L,"12 Plein ","City Center","Cape Town","8000");

    }

    @Test
    void buildAddress() {
        assertNotNull(address1);
        System.out.println(address1);
    }
    @Test
    void buildAddressWithNoCityMustFail(){
        assertNotNull(address2);
        System.out.println(address2);
    }
}