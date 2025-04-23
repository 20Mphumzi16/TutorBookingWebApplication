package za.ac.cput.za.ac.cput.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.za.ac.cput.domain.Subject;

import static org.junit.jupiter.api.Assertions.*;
class SubjectFactoryTest {
private static Subject subject1;
private static Subject subject2;
    @BeforeAll
    static void setUp() {
        subject1=SubjectFactory.build(1L,"ADP2","Applications Development 2",8);
        subject2=SubjectFactory.build(2L,"ICE","Applications Development 3",9);
    }

    @Test
    void build() {
        assertNotNull(subject1);
        System.out.println(subject1);
        assertNotNull(subject2);
        System.out.println(subject2);
    }
}