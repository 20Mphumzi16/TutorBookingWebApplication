package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate availabilityDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean booked;
    @ManyToOne
    private Tutor tutor;



    public Availability() {
    }
    private Availability(AvailabilityBuilder builder) {
        this.id=builder.id;
        this.availabilityDate=builder.availabilityDate;
        this.startTime=builder.startTime;
        this.endTime=builder.endTime;
        this.booked=builder.booked;
        this.tutor=builder.tutor;
    }
    public Tutor getTutor() {
        return tutor;
    }
    public Long getId() {
        return id;
    }

    public LocalDate getAvailabilityDate() {
        return availabilityDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public boolean isBooked() {
        return booked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Availability that = (Availability) o;
        return booked == that.booked && Objects.equals(id, that.id) && Objects.equals(availabilityDate, that.availabilityDate) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(tutor, that.tutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, availabilityDate, startTime, endTime, booked, tutor);
    }

    @Override
    public String toString() {
        return "Availability{" +
                "id=" + id +
                ", availabilityDate=" + availabilityDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", booked=" + booked +
                ", tutor=" + tutor +
                '}';
    }

    public static class AvailabilityBuilder {
        private Long id;
        private LocalDate availabilityDate;
        private LocalTime startTime;
        private LocalTime endTime;
        private boolean booked;
        private Tutor tutor;
        public AvailabilityBuilder() {

        }
        public AvailabilityBuilder tutor(Tutor tutor) {
            this.tutor = tutor;
            return this;
        }

        public AvailabilityBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public AvailabilityBuilder setAvailabilityDate(LocalDate availabilityDate) {
            this.availabilityDate = availabilityDate;
            return this;
        }

        public AvailabilityBuilder setStartTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public AvailabilityBuilder setEndTime(LocalTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public AvailabilityBuilder setBooked(boolean booked) {
            this.booked = booked;
            return this;
        }
        public AvailabilityBuilder copy(Availability availability) {
            this.id = availability.id;
            this.availabilityDate = availability.availabilityDate;
            this.startTime = availability.startTime;
            this.endTime = availability.endTime;
            this.booked = availability.booked;
            this.tutor = availability.tutor;
            return this;
        }
        public Availability build() {
            return new Availability(this);
        }
    }
}
