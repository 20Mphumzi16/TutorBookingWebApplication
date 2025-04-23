package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity

public class SubjectBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Booking booking;
    @ManyToOne
    private SubjectLevel level;

    public SubjectBooking() {

    }

    private SubjectBooking(SubjectBookingBuilder builder) {
                this.id=builder.id;
                this.subject=builder.subject;
                this.booking=builder.booking;
                this.level=builder.level;
    }

    public int getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

    public Booking getBooking() {
        return booking;
    }

    public SubjectLevel getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectBooking that = (SubjectBooking) o;
        return id == that.id && Objects.equals(subject, that.subject) && Objects.equals(booking, that.booking) && Objects.equals(level, that.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, booking, level);
    }

    @Override
    public String toString() {
        return "SubjectBooking{" +
                "id=" + id +
                ", subject=" + subject +
                ", booking=" + booking +
                ", level=" + level +
                '}';
    }
    public static class SubjectBookingBuilder {
        private int id;
        private Subject subject;
        private Booking booking;
        private SubjectLevel level;

        public SubjectBookingBuilder() {

        }

        public SubjectBookingBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public SubjectBookingBuilder setSubject(Subject subject) {
            this.subject = subject;
            return this;
        }

        public SubjectBookingBuilder setBooking(Booking booking) {
            this.booking = booking;
            return this;
        }

        public SubjectBookingBuilder setLevel(SubjectLevel level) {
            this.level = level;
            return this;
        }
        public SubjectBookingBuilder copy(SubjectBooking source) {
            this.id=source.id;
            this.subject=source.subject;
            this.booking=source.booking;
            this.level=source.level;
            return this;
        }
        public SubjectBooking build() {
            return  new SubjectBooking(this);
        }
    }

}
