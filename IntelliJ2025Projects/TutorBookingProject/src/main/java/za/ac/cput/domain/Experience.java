package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private String companyName;
    private LocalDate startDate;
    private LocalDate endDate;

    public Experience() {
    }

   private Experience(ExperienceBuilder builder) {
        this.id = builder.id;
        this.position = builder.position;
        this.companyName = builder.companyName;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public Long  getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public String getCompanyName() {
        return companyName;
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
        Experience that = (Experience) o;
        return id == that.id && Objects.equals(position, that.position) && Objects.equals(companyName, that.companyName) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position, companyName, startDate, endDate);
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", companyName='" + companyName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public static class ExperienceBuilder {
        private Long id;
        private String position;
        private String companyName;
        private LocalDate startDate;
        private LocalDate endDate;
        public ExperienceBuilder() {

        }

        public ExperienceBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ExperienceBuilder setPosition(String position) {
            this.position = position;
            return this;
        }

        public ExperienceBuilder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public ExperienceBuilder setStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public ExperienceBuilder setEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }
        public ExperienceBuilder copy(Experience experience) {
            this.id = experience.id;
            this.position = experience.position;
            this.companyName = experience.companyName;
            this.startDate = experience.startDate;
            this.endDate = experience.endDate;
            return this;
        }
        public Experience build() {
            return new Experience(this);
        }
    }
}
