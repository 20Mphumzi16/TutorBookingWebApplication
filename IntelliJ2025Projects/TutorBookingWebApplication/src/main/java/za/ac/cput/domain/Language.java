package za.ac.cput.domain;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.Mapping;

import java.util.Objects;
import java.util.Set;

@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "preferredLanguages")
    private Set<Booking> bookings;

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
        LanguageBuilder that = (LanguageBuilder) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Language() {
    }

    private Language(LanguageBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public static class LanguageBuilder {

        private Long id;
        private String name;

        public LanguageBuilder() {

        }

        public LanguageBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public LanguageBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public LanguageBuilder copy(Language language) {
            this.id = language.id;
            this.name = language.name;
            return this;
        }

        public Language build() {
            return new Language(this);
        }


    }
}
