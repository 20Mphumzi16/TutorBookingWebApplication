package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Subject;

import static org.junit.jupiter.api.Assertions.*;

class SubjectFactoryTest {
private static Subject subject1;
private static Subject subject2;
    @BeforeAll
    static void setUp() {
        subject1 =SubjectFactory.buildSubject(1L,"Java");
        subject2 =SubjectFactory.buildSubject(2L,"Python");
    }

    @Test
    void buildSubject() {
        assertNotNull(subject1);
        assertNotNull(subject2);
        System.out.println(subject1);
        System.out.println(subject2);
    }
}