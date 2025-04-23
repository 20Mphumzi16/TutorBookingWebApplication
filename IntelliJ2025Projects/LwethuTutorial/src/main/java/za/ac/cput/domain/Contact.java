package za.ac.cput.domain;

public class Contact {
    private Long id;
    private String email;
    private String phone;

    public Contact() {
    }
    public Contact(ContactBuilder builder) {
        this.id=builder.id;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static class ContactBuilder{
        private Long id;
        private String email;
        private String phone;

        public ContactBuilder() {
        }

        public ContactBuilder setId(Long id) {
            this.id = id;
            return this;
        }
        public ContactBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public ContactBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }
        public ContactBuilder copy(Contact contact) {
            this.id=contact.id;
            this.email=contact.email;
            this.phone=contact.phone;
            return this;
        }
        public Contact build(){
            return new Contact(this);
        }
    }
}
