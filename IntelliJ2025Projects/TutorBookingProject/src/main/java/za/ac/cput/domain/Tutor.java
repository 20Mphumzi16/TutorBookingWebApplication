package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@DiscriminatorValue("Tutor")
public class Tutor extends User {
    private String aboutMe;
    private int totalTeachingExperience;
    private int onlineTeachingExperience;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Experience> experience;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Education> education;
    @OneToOne(cascade = CascadeType.ALL)
    private TutorPreferences tutorPreferences;
    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    private List<Availability> availabilitySlots;

    public Tutor() {

    }

    private Tutor(TutorBuilder builder) {
        super(builder);
        this.aboutMe = builder.aboutMe;
        this.totalTeachingExperience = builder.totalTeachingExperience;
        this.onlineTeachingExperience = builder.onlineTeachingExperience;
        this.experience = builder.experience;
        this.education = builder.education;
        this.tutorPreferences = builder.tutorPreferences;

    }

    public String getAboutMe() {
        return aboutMe;
    }

    public int getTotalTeachingExperience() {
        return totalTeachingExperience;
    }

    public int getOnlineTeachingExperience() {
        return onlineTeachingExperience;
    }

    public List<Experience> getExperience() {
        return experience;
    }

    public List<Education> getEducation() {
        return education;
    }

    public TutorPreferences getTutorPreferences() {
        return tutorPreferences;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tutor tutor = (Tutor) o;
        return totalTeachingExperience == tutor.totalTeachingExperience && onlineTeachingExperience == tutor.onlineTeachingExperience && Objects.equals(aboutMe, tutor.aboutMe) && Objects.equals(experience, tutor.experience) && Objects.equals(education, tutor.education) && Objects.equals(tutorPreferences, tutor.tutorPreferences) && Objects.equals(availabilitySlots, tutor.availabilitySlots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), aboutMe, totalTeachingExperience, onlineTeachingExperience, experience, education, tutorPreferences, availabilitySlots);
    }

    @Override
    public String toString() {
        return "Tutor{" +
                " id:" + id +
                "\nname:" + name +
                "\nimage:" + Arrays.toString(image) +
                "\npassword='" + password + '\'' +
                "\nemail:'" + email + '\'' +
                "\nphone:'" + phone + '\'' +
                "\nroles:" + roles +
                "\nlanguages:" + languages +
                "\naboutMe:" + aboutMe + '\'' +
                "\ntotalTeachingExperience:" + totalTeachingExperience +
                "\nonlineTeachingExperience:" + onlineTeachingExperience +
                "\nexperience:" + experience +
                "\neducation:" + education +
                "\ntutorPreferences:" + tutorPreferences +
                        '}';
    }

    public static class TutorBuilder extends UserBuilder<Tutor.TutorBuilder> {
        private String aboutMe;
        private int totalTeachingExperience;
        private int onlineTeachingExperience;
        private List<Experience> experience;
        private List<Education> education;
        private TutorPreferences tutorPreferences;


        public TutorBuilder() {
        }

        public TutorBuilder setAboutMe(String aboutMe) {
            this.aboutMe = aboutMe;
            return this;
        }

        public TutorBuilder setTotalTeachingExperience(int totalTeachingExperience) {
            this.totalTeachingExperience = totalTeachingExperience;
            return this;
        }

        public TutorBuilder setOnlineTeachingExperience(int onlineTeachingExperience) {
            this.onlineTeachingExperience = onlineTeachingExperience;
            return this;
        }

        public TutorBuilder setExperience(List<Experience> experience) {
            this.experience = experience;
            return this;
        }

        public TutorBuilder setEducation(List<Education> education) {
            this.education = education;
            return this;
        }

        public TutorBuilder setTutorPreferences(TutorPreferences tutorPreferences) {
            this.tutorPreferences = tutorPreferences;
            return this;
        }


        public TutorBuilder copy(Tutor tutor) {
            super.copy(tutor);
            this.aboutMe = tutor.aboutMe;
            this.totalTeachingExperience = tutor.totalTeachingExperience;
            this.onlineTeachingExperience = tutor.onlineTeachingExperience;
            this.experience = tutor.experience;
            this.education = tutor.education;
            this.tutorPreferences = tutor.tutorPreferences;
            return this;
        }

        public Tutor build() {
            return new Tutor(this);
        }
    }
}
