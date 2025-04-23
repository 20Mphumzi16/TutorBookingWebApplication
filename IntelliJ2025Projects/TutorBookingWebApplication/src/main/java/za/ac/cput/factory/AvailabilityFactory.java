package za.ac.cput.factory;

import za.ac.cput.domain.Availability;
import za.ac.cput.domain.Tutor;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.time.LocalTime;

public class AvailabilityFactory {
    public static Availability buildAvailability(Long id, LocalDate availabilityDate, LocalTime startTime, LocalTime endTime, Tutor tutor, boolean booked) {
        if(id<=0|| Helper.isInPast(availabilityDate)||Helper.isInvalidTime(startTime)||Helper.isInvalidTime(endTime)||Helper.isObjectNull(tutor)){
            return null;
        }
        return new Availability.AvailabilityBuilder()
                .setId(id)
                .setAvailabilityDate(availabilityDate)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setBooked(booked)
                .tutor(tutor)
                .build();
    }
    public static Availability buildAvailability(LocalDate availabilityDate, LocalTime startTime, LocalTime endTime, Tutor tutor, boolean booked) {
        if(Helper.isInPast(availabilityDate)||Helper.isInvalidTime(startTime)||Helper.isInvalidTime(endTime)||Helper.isObjectNull(tutor)){
            return null;
        }
        return new Availability.AvailabilityBuilder()
                .setAvailabilityDate(availabilityDate)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setBooked(booked)
                .tutor(tutor)
                .build();
    }
}
