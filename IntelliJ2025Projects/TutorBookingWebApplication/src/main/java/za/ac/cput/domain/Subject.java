package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Subject() {
    }

   private Subject(SubjectBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(id, subject.id) && Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public static class SubjectBuilder {
        private Long id;
        private String name;

        public SubjectBuilder() {
        }
        public SubjectBuilder setId(Long id) {
            this.id = id;
            return this;
        }
        public SubjectBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public SubjectBuilder copy(Subject subject) {
            this.id = subject.id;
            this.name = subject.name;
            return this;
        }
        public Subject build() {
            return new Subject(this);
        }

    }
}
