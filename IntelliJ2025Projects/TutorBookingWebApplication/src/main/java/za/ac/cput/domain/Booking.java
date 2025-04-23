package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime bookingDateTime;
    private LocalDate sessionDate;
    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Enumerated(EnumType.STRING)
    private BookingMode mode;  // ONLINE or ON_CAMPUS

    private double duration;  // in hours

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "booking_subject",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;

    @ManyToMany(fetch = FetchType.EAGER)

    private List<Language> preferredLanguages;

    private String additionalNotes;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    public Booking() {
    }

    public Booking(BookingBuilder builder) {
        this.id = builder.id;
        this.bookingDateTime = builder.bookingDateTime;
        this.sessionDate = builder.sessionDate;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.student = builder.student;
        this.tutor = builder.tutor;
        this.mode = builder.mode;
        this.duration = builder.duration;
        this.subjects = builder.subjects;
        this.preferredLanguages = builder.preferredLanguages;
        this.additionalNotes = builder.additionalNotes;
        this.status = builder.status;

    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public Student getStudent() {
        return student;
    }

    public BookingMode getMode() {
        return mode;
    }

    public double getDuration() {
        return duration;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<Language> getPreferredLanguages() {
        return preferredLanguages;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public BookingStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id && Double.compare(duration, booking.duration) == 0 && Objects.equals(bookingDateTime, booking.bookingDateTime) && Objects.equals(sessionDate, booking.sessionDate) && Objects.equals(startTime, booking.startTime) && Objects.equals(endTime, booking.endTime) && Objects.equals(tutor, booking.tutor) && Objects.equals(student, booking.student) && mode == booking.mode && Objects.equals(subjects, booking.subjects) && Objects.equals(preferredLanguages, booking.preferredLanguages) && Objects.equals(additionalNotes, booking.additionalNotes) && status == booking.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookingDateTime, sessionDate, startTime, endTime, tutor, student, mode, duration, subjects, preferredLanguages, additionalNotes, status);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookingDateTime=" + bookingDateTime +
                ", sessionDate=" + sessionDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", tutor=" + tutor +
                ", student=" + student +
                ", mode=" + mode +
                ", duration=" + duration +
                ", subjects=" + subjects +
                ", preferredLanguages=" + preferredLanguages +
                ", additionalNotes='" + additionalNotes + '\'' +
                ", status=" + status +
                '}';
    }

    public static class BookingBuilder {
        private Long id;
        private LocalDateTime bookingDateTime;
        private LocalDate sessionDate;
        private LocalTime startTime;
        private LocalTime endTime;
        private Tutor tutor;
        private Student student;
        private BookingMode mode;
        private double duration;
        private List<Subject> subjects;
        private List<Language> preferredLanguages;
        private String additionalNotes;
        private BookingStatus status;

        public BookingBuilder() {

        }

        public BookingBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public BookingBuilder setBookingDateTime(LocalDateTime bookingDateTime) {
            this.bookingDateTime = bookingDateTime;
            return this;
        }

        public BookingBuilder setSessionDate(LocalDate sessionDate) {
            this.sessionDate = sessionDate;
            return this;
        }

        public BookingBuilder setStartTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public BookingBuilder setEndTime(LocalTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public BookingBuilder setTutor(Tutor tutor) {
            this.tutor = tutor;
            return this;
        }

        public BookingBuilder setStudent(Student student) {
            this.student = student;
            return this;
        }

        public BookingBuilder setMode(BookingMode mode) {
            this.mode = mode;
            return this;
        }

        public BookingBuilder setDuration(double duration) {
            this.duration = duration;
            return this;
        }

        public BookingBuilder setSubjects(List<Subject> subjects) {
            this.subjects = subjects;
            return this;
        }

        public BookingBuilder setPreferredLanguages(List<Language> preferredLanguages) {
            this.preferredLanguages = preferredLanguages;
            return this;
        }

        public BookingBuilder setAdditionalNotes(String additionalNotes) {
            this.additionalNotes = additionalNotes;
            return this;
        }

        public BookingBuilder setStatus(BookingStatus status) {
            this.status = status;
            return this;
        }

        public BookingBuilder copy(Booking booking) {
            this.id = booking.id;
            this.bookingDateTime = booking.bookingDateTime;
            this.sessionDate = booking.sessionDate;
            this.startTime = booking.startTime;
            this.endTime = booking.endTime;
            this.tutor = booking.tutor;
            this.student = booking.student;
            this.mode = booking.mode;
            this.duration = booking.duration;
            this.subjects = booking.subjects;
            this.preferredLanguages = booking.preferredLanguages;
            this.additionalNotes = booking.additionalNotes;
            this.status = booking.status;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }

}
