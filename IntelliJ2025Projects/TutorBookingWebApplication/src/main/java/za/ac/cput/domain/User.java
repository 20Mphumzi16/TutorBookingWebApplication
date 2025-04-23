package za.ac.cput.domain;
import jakarta.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Embedded
    protected Name name;
    @Lob()
    @Column(length = 100000, nullable = true)
    protected byte[] image;
    protected String password;
    protected String email;
    protected String phone;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(

            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    protected Set<Role> roles;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(

            name = "user_language",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    protected List<Language> languages;

    public User() {
    }

    protected User(UserBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.image = builder.image;
        this.password = builder.password;
        this.email = builder.email;
        this.phone = builder.phone;
        this.languages = builder.languages;
        this.roles = builder.roles;

    }

    public Long getId() {
        return id;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public Name getName() {
        return name;
    }

    public byte[] getImage() {
        return image;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", image=" + Arrays.toString(image) + ", password='" + password + '\'' + ", email='" + email + '\'' + ", phone='" + phone + '\'' + ", roles=" + roles + ", languages=" + languages + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.deepEquals(image, user.image) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(phone, user.phone) && Objects.equals(roles, user.roles) && Objects.equals(languages, user.languages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, Arrays.hashCode(image), password, email, phone, roles, languages);

    }
        public static class UserBuilder<T extends UserBuilder<T>> {
            protected Long id;
            protected Name name;
            protected byte[] image;
            protected String password;
            protected String email;
            protected String phone;
            protected Set<Role> roles;
            protected List<Language> languages;

            public T setId(Long id) {
                this.id = id;
                return (T) this;
            }

            public T setPassword(String password) {
                this.password = password;
                return (T) this;
            }
            public T setLanguages(List<Language> languages) {
                this.languages=languages;
                return (T) this;
            }

            public T setEmail(String email) {
                this.email = email;
                return (T) this;
            }

            public T setPhone(String phone) {
                this.phone = phone;
                return (T) this;
            }

            public T copy(User user) {
                this.id = user.id;
                this.name = user.name;
                this.image = user.image;
                this.password = user.password;
                this.email = user.email;
                this.phone = user.phone;
                this.roles = user.roles;
                this.languages = user.languages;
                return (T)this;
            }

            public T setRoles(Set<Role> roles) {
                this.roles = roles;
                return (T) this;
            }

            public T setImage(byte[] image) {
                this.image = image;
                return (T) this;
            }

            public T setName(Name name) {
                this.name = name;
                return (T) this;
            }

            public User build() {
                return new User(this);
            }
        }

}
