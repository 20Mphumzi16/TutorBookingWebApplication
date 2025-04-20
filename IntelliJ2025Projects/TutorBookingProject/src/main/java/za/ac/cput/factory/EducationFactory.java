package za.ac.cput.factory;

import za.ac.cput.domain.Education;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class EducationFactory {
    public static Education build( String institution, String qualificationName, LocalDate startDate, LocalDate endDate){
        if( Helper.isStringNullorEmpty(institution)||Helper.isStringNullorEmpty(qualificationName)||Helper.isFutureDate(startDate)||Helper.isAfter(startDate,endDate)){
            return null;
        }
        return new Education.EducationBuilder()
                .setInstitution(institution)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setQualificationName(qualificationName)
                .build();
    }
    public static Education build( Long id,String institution, String qualificationName, LocalDate startDate, LocalDate endDate){
        if( id<=0||Helper.isStringNullorEmpty(institution)||Helper.isStringNullorEmpty(qualificationName)||Helper.isFutureDate(startDate)||Helper.isAfter(startDate,endDate)){
            return null;
        }
        return new Education.EducationBuilder()
                .setId(id)
                .setInstitution(institution)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setQualificationName(qualificationName)
                .build();
    }
}
