package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Experience;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ExperienceFactoryTest {
    private static Experience experience1;
    private static Experience experience2;
    private static Experience experience3;
    @BeforeAll
    static void setUp() {
        experience1=ExperienceFactory.build(1L,"Junior Software Engineer","Amazon", LocalDate.of(2019,12,01),LocalDate.of(2021,06,20));
        experience2=ExperienceFactory.build(2L,"Intern Developer","", LocalDate.of(2018,07,17),LocalDate.of(2022,11,16));
        experience3=ExperienceFactory.build(3L,"Junior Software Engineer","Amazon", LocalDate.of(2025,01,01),LocalDate.of(2025,05,20));

    }

    @Test
    void build() {
        assertNotNull(experience1);
        System.out.println(experience1);
    }

    @Test
    void buildWithNullCompanyNameMustFail() {
        assertNull(experience2);
        System.out.println(experience2);
    }

    @Test
    void buildWithFutureEndDateMustFail() {
        assertNull(experience3);
        System.out.println(experience3);
    }
}