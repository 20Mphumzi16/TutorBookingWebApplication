package za.ac.cput.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Arrays;
import java.util.Set;

@Entity
@DiscriminatorValue("Student")
public class Student extends User {
    private int yearOfStudy;

    public Student() {
    }

    private Student(StudentBuilder builder) {
        super(builder);
        this.yearOfStudy = builder.yearOfStudy;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    @Override
    public String toString() {
        return "Student{" +
                "yearOfStudy=" + yearOfStudy +
                ", id=" + id +
                ", name=" + name +
                ", image=" + Arrays.toString(image) +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", roles=" + roles +
                ", languages=" + languages +
                '}';
    }

    public static class StudentBuilder extends UserBuilder<StudentBuilder> {
        private int yearOfStudy;

        public StudentBuilder() {
        }

        public StudentBuilder setYearOfStudy(int yearOfStudy) {
            this.yearOfStudy = yearOfStudy;
            return this;
        }

        public StudentBuilder copy(Student student) {
            super.copy(student);
            this.yearOfStudy = student.yearOfStudy;
            return this;

        }


        public Student build() {
            return new Student(this);
        }
    }
}
