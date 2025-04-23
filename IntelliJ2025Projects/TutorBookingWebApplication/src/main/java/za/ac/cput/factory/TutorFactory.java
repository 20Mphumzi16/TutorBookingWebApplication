package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

import java.util.List;
import java.util.Set;

public class TutorFactory {
    public static Tutor buildTutor(Long id, String firstName, String preferredName, String lastName, byte[] image, String password, String email, String phoneNumber, Set<Role> roles, List<Language> languages, String aboutMe, int totalTeachingExperience, int onlineTeachingExperience, List<Experience> experienceList, List<Education> educationList, TutorPreferences preferences) {
        if (id <= 0 ||
                Helper.isStringNullorEmpty(firstName) ||
                Helper.isStringNullorEmpty(preferredName) ||
                Helper.isArrayNullOrEmpty(image) ||
                Helper.isStringNullorEmpty(password) ||
                Helper.isEmailValid(email) ||
                Helper.isNumber10Digits(phoneNumber) ||
                Helper.isSetNullorEmpty(roles) ||
                Helper.isListNullorEmpty(languages) ||
                Helper.isStringNullorEmpty(aboutMe) ||
                totalTeachingExperience < 0 ||
                onlineTeachingExperience < 0 ||
                Helper.isListNullorEmpty(experienceList) ||
                Helper.isListNullorEmpty(educationList)||
                Helper.isObjectNull(preferences)

        ) {
            return null;
        }
        Name name = new Name.NameBuilder()
                .setFirstName(firstName)
                .setPreferredName(preferredName)
                .setLastName(lastName)
                .build();

        return new Tutor.TutorBuilder()
                .setId(id)
                .setName(name)
                .setImage(image)
                .setPassword(password)
                .setPhone(phoneNumber)
                .setEmail(email)
                .setLanguages(languages)
                .setRoles(roles)
                .setAboutMe(aboutMe)
                .setEducation(educationList)
                .setExperience(experienceList)
                .setTotalTeachingExperience(totalTeachingExperience)
                .setOnlineTeachingExperience(onlineTeachingExperience)
                .setTutorPreferences(preferences)
                .build();
    }

    public static Tutor buildTutor(Long id, String firstName, String lastName, byte[] image, String password, String email, String phoneNumber, Set<Role> roles, List<Language> languages, String aboutMe, int totalTeachingExperience, int onlineTeachingExperience, List<Experience> experienceList, List<Education> educationList, TutorPreferences preferences) {
        if (id <= 0 ||
                Helper.isStringNullorEmpty(firstName) ||
                Helper.isArrayNullOrEmpty(image) ||
                Helper.isStringNullorEmpty(password) ||
                Helper.isEmailValid(email) ||
                Helper.isNumber10Digits(phoneNumber) ||
                Helper.isSetNullorEmpty(roles) ||
                Helper.isListNullorEmpty(languages) ||
                Helper.isStringNullorEmpty(aboutMe) ||
                totalTeachingExperience < 0 ||
                onlineTeachingExperience < 0 ||
                Helper.isListNullorEmpty(experienceList) ||
                Helper.isListNullorEmpty(educationList) ||
                Helper.isObjectNull(preferences)

        ) {
            return null;
        }
        Name name = new Name.NameBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();

        return new Tutor.TutorBuilder()
                .setId(id)
                .setName(name)
                .setImage(image)
                .setPassword(password)
                .setPhone(phoneNumber)
                .setEmail(email)
                .setLanguages(languages)
                .setRoles(roles)
                .setAboutMe(aboutMe)
                .setEducation(educationList)
                .setExperience(experienceList)
                .setTutorPreferences(preferences)
                .setTotalTeachingExperience(totalTeachingExperience)
                .setOnlineTeachingExperience(onlineTeachingExperience)
                .build();
    }
    public static Tutor buildTutor( String firstName, String preferredName, String lastName, byte[] image, String password, String email, String phoneNumber, Set<Role> roles, List<Language> languages, String aboutMe, int totalTeachingExperience, int onlineTeachingExperience, List<Experience> experienceList, List<Education> educationList, TutorPreferences preferences) {
        if (
                Helper.isStringNullorEmpty(firstName) ||
                Helper.isStringNullorEmpty(preferredName) ||
                Helper.isArrayNullOrEmpty(image) ||
                Helper.isStringNullorEmpty(password) ||
                Helper.isEmailValid(email) ||
                Helper.isNumber10Digits(phoneNumber) ||
                Helper.isSetNullorEmpty(roles) ||
                Helper.isListNullorEmpty(languages) ||
                Helper.isStringNullorEmpty(aboutMe) ||
                totalTeachingExperience < 0 ||
                onlineTeachingExperience < 0 ||
                Helper.isListNullorEmpty(experienceList) ||
                Helper.isListNullorEmpty(educationList)||
                Helper.isObjectNull(preferences)

        ) {
            return null;
        }
        Name name = new Name.NameBuilder()
                .setFirstName(firstName)
                .setPreferredName(preferredName)
                .setLastName(lastName)
                .build();

        return new Tutor.TutorBuilder()

                .setName(name)
                .setImage(image)
                .setPassword(password)
                .setPhone(phoneNumber)
                .setEmail(email)
                .setLanguages(languages)
                .setRoles(roles)
                .setAboutMe(aboutMe)
                .setEducation(educationList)
                .setExperience(experienceList)
                .setTotalTeachingExperience(totalTeachingExperience)
                .setOnlineTeachingExperience(onlineTeachingExperience)
                .setTutorPreferences(preferences)
                .build();
    }

    public static Tutor buildTutor(String firstName, String lastName, byte[] image, String password, String email, String phoneNumber, Set<Role> roles, List<Language> languages, String aboutMe, int totalTeachingExperience, int onlineTeachingExperience, List<Experience> experienceList, List<Education> educationList, TutorPreferences preferences) {
        if (
                Helper.isStringNullorEmpty(firstName) ||
                Helper.isArrayNullOrEmpty(image) ||
                Helper.isStringNullorEmpty(password) ||
                Helper.isEmailValid(email) ||
                Helper.isNumber10Digits(phoneNumber) ||
                Helper.isSetNullorEmpty(roles) ||
                Helper.isListNullorEmpty(languages) ||
                Helper.isStringNullorEmpty(aboutMe) ||
                totalTeachingExperience < 0 ||
                onlineTeachingExperience < 0 ||
                Helper.isListNullorEmpty(experienceList) ||
                Helper.isListNullorEmpty(educationList) ||
                Helper.isObjectNull(preferences)

        ) {
            return null;
        }
        Name name = new Name.NameBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();

        return new Tutor.TutorBuilder()
                .setName(name)
                .setImage(image)
                .setPassword(password)
                .setPhone(phoneNumber)
                .setEmail(email)
                .setLanguages(languages)
                .setRoles(roles)
                .setAboutMe(aboutMe)
                .setEducation(educationList)
                .setExperience(experienceList)
                .setTutorPreferences(preferences)
                .setTotalTeachingExperience(totalTeachingExperience)
                .setOnlineTeachingExperience(onlineTeachingExperience)
                .build();
    }
}
