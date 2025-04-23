package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Student;
import za.ac.cput.util.Helper;

public class StudentFactory {
    public static Student buildStudent(Long id, String fisrtName, String middleName, String lastName, String gender, int age, Contact contact) {
        if (id <= 0 ||

                Helper.isStringNullOrEmpty(fisrtName) ||
                Helper.isStringNullOrEmpty(middleName) ||
                Helper.isStringNullOrEmpty(lastName) ||
                Helper.isStringNullOrEmpty(gender) ||
                Helper.isInvalidAge(age) ||
                Helper.isObjectNullOrEmpty(contact)) {
            return null;
        }
        Name name = new Name.NameBuilder()
                .setFirstName(fisrtName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .build();

        return new Student.StudentBuilder()
                .setId(id)
                .setAge(age)
                .setContact(contact)
                .setGender(gender)
                .setName(name)
                .build();

    }

    public static Student buildStudent(Long id, String fisrtName, String lastName, String gender, int age, Contact contact) {
        if (id <= 0 ||

                Helper.isStringNullOrEmpty(fisrtName) ||
                Helper.isStringNullOrEmpty(lastName) ||
                Helper.isStringNullOrEmpty(gender) ||
                Helper.isInvalidAge(age) ||
                Helper.isObjectNullOrEmpty(contact)) {
            return null;
        }
        Name name = new Name.NameBuilder()
                .setFirstName(fisrtName)
                .setLastName(lastName)
                .build();

        return new Student.StudentBuilder()
                .setId(id)
                .setAge(age)
                .setContact(contact)
                .setGender(gender)
                .setName(name)
                .build();

    }
}
