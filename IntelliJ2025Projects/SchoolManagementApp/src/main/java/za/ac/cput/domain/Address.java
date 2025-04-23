package za.ac.cput.domain;

public class Address {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address() {
    }
    public Address(AddressBuilder builder) {
        this.id = builder.id;
        this.street = builder.street;
        this.city = builder.city;
        this.state = builder.state;
        this.zip = builder.zip;

    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
    public static class AddressBuilder{
        private Long id;
        private String street;
        private String city;
        private String state;
        private String zip;

        public AddressBuilder() {
        }

        public AddressBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public AddressBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder setState(String state) {
            this.state = state;
            return this;
        }

        public AddressBuilder setZip(String zip) {
            this.zip = zip;
            return this;
        }
        public Address build() {
            return new Address(this);
        }
    }
}
