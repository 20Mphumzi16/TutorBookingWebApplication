package za.ac.cput.domain;

public class Student {
    private Long id;
    private Name name;
    private String gender;
    private int age;
    private Contact contact;

    public Student() {
    }
    public Student(StudentBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.gender = builder.gender;
        this.age = builder.age;
        this.contact = builder.contact;

    }



    public  Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", contact=" + contact +
                '}';
    }

    public static class StudentBuilder {
        private Long id;
        private Name name;
        private String gender;
        private int age;
        private Contact contact;

        public StudentBuilder() {
        }

        public StudentBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public StudentBuilder setName(Name name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }
        public Student build() {
            return new Student(this);
        }
    }
}
