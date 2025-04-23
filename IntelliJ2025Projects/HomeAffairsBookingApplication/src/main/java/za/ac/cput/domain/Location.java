package za.ac.cput.domain;

import java.util.Objects;

public class Location {
    private Long locationId;
    private String locationName;
    private Address address;

    public Location() {
    }

    public Location(LocationBuilder builder) {
        this.locationId = builder.locationId;
        this.locationName = builder.locationName;
        this.address = builder.address;
    }

    public Long getLocationId() {
        return locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return locationId == location.locationId && Objects.equals(locationName, location.locationName) && Objects.equals(address, location.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, locationName, address);
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", locationName='" + locationName + '\'' +
                ", address=" + address +
                '}';
    }

    public static class LocationBuilder {
        private Long locationId;
        private String locationName;
        private Address address;

        public LocationBuilder() {

        }

        public LocationBuilder setLocationId(Long locationId) {
            this.locationId = locationId;
            return this;
        }

        public LocationBuilder setLocationName(String locationName) {
            this.locationName = locationName;
            return this;
        }

        public LocationBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public LocationBuilder copy(Location location) {

            this.locationId = location.locationId;
            this.locationName = location.locationName;
            this.address = location.address;
            return this;

        }

        public Location build() {
            return new Location(this);
        }
    }


}
