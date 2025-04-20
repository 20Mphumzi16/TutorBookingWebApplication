package za.ac.cput.factory;

import za.ac.cput.domain.Experience;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class ExperienceFactory {
    public static Experience build(Long id, String position, String companyName, LocalDate startDate, LocalDate endDate) {
        if(id<=0|| Helper.isStringNullorEmpty(position) || Helper.isStringNullorEmpty(companyName)||Helper.isFutureDate(startDate)||Helper.isFutureDate(endDate)||Helper.isAfter(startDate,endDate)){
            return null;
        }
        return new Experience.ExperienceBuilder()
                .setId(id)
                .setCompanyName(companyName)
                .setPosition(position)
                .setEndDate(endDate)
                .setStartDate(startDate)
                .build();
    }

    public static Experience build(String position, String companyName, LocalDate startDate, LocalDate endDate) {
        if(Helper.isStringNullorEmpty(position) || Helper.isStringNullorEmpty(companyName)||Helper.isFutureDate(startDate)||Helper.isFutureDate(endDate)||Helper.isAfter(startDate,endDate)){
            return null;
        }
        return new Experience.ExperienceBuilder()
                .setCompanyName(companyName)
                .setPosition(position)
                .setEndDate(endDate)
                .setStartDate(startDate)
                .build();
    }
}
