package za.ac.cput.domain;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name() {
    }

    public Name(NameBuilder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class NameBuilder{
        private String firstName;
        private String middleName;
        private String lastName;

        public NameBuilder() {
        }

        public NameBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public NameBuilder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public NameBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Name build() {
            return new Name(this);
        }

    }
}
