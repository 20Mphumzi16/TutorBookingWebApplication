package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Location;

import static org.junit.jupiter.api.Assertions.*;

class LocationFactoryTest {
    private static Location location1;
    private static Location location2;
    private static Address address1;
    private static Address address2;

    @BeforeAll
    static void setUp() {
        address1 = AddressFactory.buildAddress(1L, "106 Ny6 ", "Guguethu", "Cape Town", "7750");
        address2 = AddressFactory.buildAddress(2L, "12 Plein ", "City Center", "Cape Town", "8000");
        location1 = LocationFactory.build(1L, "Home Affairs Phillipi", address1);
        location2 = LocationFactory.build(2L, "Home Affairs Kloef", address2);
    }

    @Test
    void build() {

        assertNotNull(location1);
        System.out.println(location1);
        assertNotNull(location2);
        System.out.println(location2);
    }

}