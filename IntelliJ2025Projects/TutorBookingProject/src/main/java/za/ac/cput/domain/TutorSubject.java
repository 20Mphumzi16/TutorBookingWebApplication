package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "tutor_subject")
public class TutorSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    private String fromLevel;
    private String toLevel;

    public TutorSubject() {
    }

    public TutorSubject(Long id, Tutor tutor, Subject subject, String fromLevel, String toLevel) {
        this.id = id;
        this.tutor = tutor;
        this.subject = subject;
        this.fromLevel = fromLevel;
        this.toLevel = toLevel;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Tutor getTutor() { return tutor; }
    public void setTutor(Tutor tutor) { this.tutor = tutor; }

    public Subject getSubject() { return subject; }
    public void setSubject(Subject subject) { this.subject = subject; }

    public String getFromLevel() { return fromLevel; }
    public void setFromLevel(String fromLevel) { this.fromLevel = fromLevel; }

    public String getToLevel() { return toLevel; }
    public void setToLevel(String toLevel) { this.toLevel = toLevel; }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TutorSubject that = (TutorSubject) o;
        return Objects.equals(id, that.id) && Objects.equals(tutor, that.tutor) && Objects.equals(subject, that.subject) && Objects.equals(fromLevel, that.fromLevel) && Objects.equals(toLevel, that.toLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tutor, subject, fromLevel, toLevel);
    }

    @Override
    public String toString() {
        return "TutorSubject{" +
                "id=" + id +
                ", tutor=" + tutor +
                ", subject=" + subject +
                ", fromLevel='" + fromLevel + '\'' +
                ", toLevel='" + toLevel + '\'' +
                '}';
    }


}
