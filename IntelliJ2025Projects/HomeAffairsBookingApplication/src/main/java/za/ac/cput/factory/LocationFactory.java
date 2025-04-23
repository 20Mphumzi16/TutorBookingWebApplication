package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Location;
import za.ac.cput.util.Helper;

public class LocationFactory {
    public static Location build(Long id, String name, Address address){

        if(id<=0|| Helper.isStringNullOrEmpty(name)||address==null){
            return null;
        }
        return new Location.LocationBuilder()
                .setLocationId(id)
                .setLocationName(name)
                .setAddress(address)
                .build();
    }
}
