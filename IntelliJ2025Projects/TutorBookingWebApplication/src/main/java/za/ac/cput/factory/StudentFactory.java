package za.ac.cput.factory;

import za.ac.cput.domain.Language;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.Student;
import za.ac.cput.util.Helper;

import java.util.List;
import java.util.Set;

public class StudentFactory {
    public static Student buildStudent(Long id, String firstName, String preferredName, String lastName, byte[] image, String password, String email, String phoneNumber, Set<Role> roles, List<Language> languages, int yearOfStudy) {
        if (id <= 0 ||
                Helper.isStringNullorEmpty(firstName) ||
                Helper.isStringNullorEmpty(preferredName) ||
                Helper.isArrayNullOrEmpty(image) ||
                Helper.isStringNullorEmpty(password) ||
                Helper.isEmailValid(email) ||
                Helper.isNumber10Digits(phoneNumber) ||
                Helper.isSetNullorEmpty(roles) ||
                Helper.isListNullorEmpty(languages) ||
                yearOfStudy <= 0
        ) {
            return null;
        }
        Name name = new Name.NameBuilder()
                .setFirstName(firstName)
                .setPreferredName(preferredName)
                .setLastName(lastName)
                .build();
        return new Student.StudentBuilder()
                .setId(id)
                .setName(name)
                .setImage(image)
                .setPassword(password)
                .setPhone(phoneNumber)
                .setEmail(email)
                .setLanguages(languages)
                .setRoles(roles)
                .setYearOfStudy(yearOfStudy)
                .build();

    }

    public static Student buildStudent(Long id, String firstName,String lastName, byte[] image, String password, String email, String phoneNumber, Set<Role> roles, List<Language> languages, int yearOfStudy) {
        if (id <= 0 ||
                Helper.isStringNullorEmpty(firstName) ||
                Helper.isArrayNullOrEmpty(image) ||
                Helper.isStringNullorEmpty(password) ||
                Helper.isEmailValid(email) ||
                Helper.isNumber10Digits(phoneNumber) ||
                Helper.isSetNullorEmpty(roles) ||
                Helper.isListNullorEmpty(languages) ||
                yearOfStudy <= 0
        ) {
            return null;
        }
        Name name = new Name.NameBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
        return new Student.StudentBuilder()
                .setId(id)
                .setName(name)
                .setImage(image)
                .setPassword(password)
                .setPhone(phoneNumber)
                .setEmail(email)
                .setLanguages(languages)
                .setRoles(roles)
                .setYearOfStudy(yearOfStudy)
                .build();

    }

    public static Student buildStudent( String firstName, String preferredName, String lastName, byte[] image, String password, String email, String phoneNumber, Set<Role> roles, List<Language> languages, int yearOfStudy) {
        if (
                Helper.isStringNullorEmpty(firstName) ||
                Helper.isStringNullorEmpty(preferredName) ||
                Helper.isArrayNullOrEmpty(image) ||
                Helper.isStringNullorEmpty(password) ||
                Helper.isEmailValid(email) ||
                Helper.isNumber10Digits(phoneNumber) ||
                Helper.isSetNullorEmpty(roles) ||
                Helper.isListNullorEmpty(languages) ||
                yearOfStudy <= 0
        ) {
            return null;
        }
        Name name = new Name.NameBuilder()
                .setFirstName(firstName)
                .setPreferredName(preferredName)
                .setLastName(lastName)
                .build();
        return new Student.StudentBuilder()
                .setName(name)
                .setImage(image)
                .setPassword(password)
                .setEmail(email)
                .setPhone(phoneNumber)
                .setLanguages(languages)
                .setRoles(roles)
                .setYearOfStudy(yearOfStudy)
                .build();

    }

    public static Student buildStudent(String firstName,String lastName, byte[] image, String password, String email, String phoneNumber, Set<Role> roles, List<Language> languages, int yearOfStudy) {
        if (
                Helper.isStringNullorEmpty(firstName) ||
                Helper.isArrayNullOrEmpty(image) ||
                Helper.isStringNullorEmpty(password) ||
                Helper.isEmailValid(email) ||
                Helper.isNumber10Digits(phoneNumber) ||
                Helper.isSetNullorEmpty(roles) ||
                Helper.isListNullorEmpty(languages) ||
                yearOfStudy <= 0
        ) {
            return null;
        }
        Name name = new Name.NameBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
        return new Student.StudentBuilder()
                .setName(name)
                .setImage(image)
                .setPassword(password)
                .setPhone(phoneNumber)
                .setEmail(email)
                .setLanguages(languages)
                .setRoles(roles)
                .setYearOfStudy(yearOfStudy)
                .build();

    }
}
