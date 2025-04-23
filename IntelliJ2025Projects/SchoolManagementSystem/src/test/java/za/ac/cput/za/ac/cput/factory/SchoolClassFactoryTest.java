package za.ac.cput.za.ac.cput.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.za.ac.cput.domain.SchoolClass;
import za.ac.cput.za.ac.cput.domain.Subject;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SchoolClassFactoryTest {
private static Subject subject1;
private static Subject subject2;
private static SchoolClass schoolClass1;
private static SchoolClass schoolClass2;
private static List<Subject> subjectList1;
private static List<Subject> subjectList2;
    @BeforeAll
    static void setUp() {
        subject1=SubjectFactory.build(1L,"ADP2","Applications Development 2",8);
        subject2=SubjectFactory.build(2L,"ICE","Applications Development 3",9);

        subjectList1=new ArrayList<Subject>();
        subjectList2=new ArrayList<Subject>();

        subjectList1.add(subject1);
        subjectList2.add(subject2);

        schoolClass1=SchoolClassFactory.build(1L,subjectList1,9);
        schoolClass2=SchoolClassFactory.build(2L,subjectList2,10);
    }

    @Test
    void build() {
        assertNotNull(schoolClass1);
        assertNotNull(schoolClass2);
        System.out.println(schoolClass1);
        System.out.println(schoolClass2);
    }
}