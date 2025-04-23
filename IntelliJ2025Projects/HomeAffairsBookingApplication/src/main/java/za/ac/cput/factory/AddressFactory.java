package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;

public class AddressFactory {
    public static Address buildAddress(Long id, String street, String suburb, String city, String postalCode) {
        if (id <= 0
                || Helper.isStringNullOrEmpty(street)
                || Helper.isStringNullOrEmpty(city)
                || Helper.isStringNullOrEmpty(suburb)
                || Helper.isStringNullOrEmpty(postalCode)) {
            return null;
        }
        return new Address.AddressBuilder()
                .setId(id)
                .setStreet(street)
                .setSuburb(suburb)
                .setCity(city)
                .setPostalCode(postalCode)
                .build();

    }
}
