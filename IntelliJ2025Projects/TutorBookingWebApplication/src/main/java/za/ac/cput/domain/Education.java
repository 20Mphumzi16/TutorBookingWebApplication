package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String institution;
    private String qualificationName;
    private LocalDate startDate;
    private LocalDate endDate;

    public Education() {
    }

  private Education(EducationBuilder builder) {
        this.id=builder.id;
        this.institution=builder.institution;
        this.qualificationName=builder.qualificationName;
        this.startDate=builder.startDate;
        this.endDate=builder.endDate;
    }

    public Long getId() {
        return id;
    }

    public String getInstitution() {
        return institution;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return Objects.equals(id, education.id) && Objects.equals(institution, education.institution) && Objects.equals(qualificationName, education.qualificationName) && Objects.equals(startDate, education.startDate) && Objects.equals(endDate, education.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, institution, qualificationName, startDate, endDate);
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", institution='" + institution + '\'' +
                ", qualificationName='" + qualificationName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public static class EducationBuilder {
        private Long id;
        private String institution;
        private String qualificationName;
        private LocalDate startDate;
        private LocalDate endDate;
        public EducationBuilder() {

        }

        public EducationBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public EducationBuilder setInstitution(String institution) {
            this.institution = institution;
            return this;
        }

        public EducationBuilder setQualificationName(String qualificationName) {
            this.qualificationName = qualificationName;
            return this;
        }

        public EducationBuilder setStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public EducationBuilder setEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }
        public EducationBuilder copy(Education education)
        {
            this.id=education.id;
            this.institution=education.institution;
            this.qualificationName=education.qualificationName;
            this.startDate=education.startDate;
            this.endDate=education.endDate;
            return this;
        }
        public Education build() {
            return new Education(this);
        }
    }
}
