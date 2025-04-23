package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Education;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EducationFactoryTest {
private static Education education1;
private static Education education2;
private static Education education3;
    @BeforeAll
    static void setUp() {
        education1=EducationFactory.build(1L,"UWC","Computer Science", LocalDate.of(2022,01,01),LocalDate.of(2024,12,31));
        education2=EducationFactory.build(2L,"CPUT","IT", LocalDate.of(2019,01,01),LocalDate.of(2020,12,31));
        education3=EducationFactory.build(3L,"","HC ICT",
                LocalDate.of(2021,01,01),LocalDate.of(2021,12,31));
    }

    @Test
    void build() {
        assertNotNull(education1);
        System.out.println(education1);

        assertNotNull(education2);
        System.out.println(education2);
    }
    @Test
    void buildEducationWithInvalidInstitutionName(){
        assertNull(education3);
        System.out.println(education3);
    }
}