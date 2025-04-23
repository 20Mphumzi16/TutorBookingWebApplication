package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class BookingFactory {

    public static Booking build(Long id,
                                LocalDateTime bookingDateTime,
                                LocalDate sessionDate,
                                LocalTime startTime,
                                LocalTime endTime,
                                Tutor tutor,
                                Student student,
                                BookingMode bookingMode,
                                double duration,
                                List<Subject> subjects,
                                List<Language> preferredLanguages,
                                String additionalNotes,
                                BookingStatus bookingStatus) {

        if (id <= 0||
                Helper.isInValidDateTime(bookingDateTime) ||
                Helper.isValidDate(sessionDate) ||
                Helper.isInvalidTime(startTime) ||
                Helper.isInvalidTime(endTime) ||
                Helper.isObjectNull(tutor) ||
                Helper.isObjectNull(student) ||
                Helper.isObjectNull(bookingMode) ||
                Helper.isListNullorEmpty(subjects) ||
                Helper.isListNullorEmpty(preferredLanguages) ||
                Helper.isStringNullorEmpty(additionalNotes) ||
                Helper.isObjectNull(bookingStatus)

        ) {
            return null;

        }
        return new Booking.BookingBuilder()
                .setId(id)
                .setBookingDateTime(bookingDateTime)
                .setSessionDate(sessionDate)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setTutor(tutor)
                .setStudent(student)
                .setMode(bookingMode)
                .setDuration(duration)
                .setSubjects(subjects)
                .setPreferredLanguages(preferredLanguages)
                .setAdditionalNotes(additionalNotes)
                .setStatus(bookingStatus)
                .build();


    }

    public static Booking build(
                                LocalDateTime bookingDateTime,
                                LocalDate sessionDate,
                                LocalTime startTime,
                                LocalTime endTime,
                                Tutor tutor,
                                Student student,
                                BookingMode bookingMode,
                                double duration,
                                List<Subject> subjects,
                                List<Language> preferredLanguages,
                                String additionalNotes,
                                BookingStatus bookingStatus) {

        if (
                Helper.isInValidDateTime(bookingDateTime) ||
                Helper.isValidDate(sessionDate) ||
                Helper.isInvalidTime(startTime) ||
                Helper.isInvalidTime(endTime) ||
                Helper.isObjectNull(tutor) ||
                Helper.isObjectNull(student) ||
                Helper.isObjectNull(bookingMode) ||
                Helper.isListNullorEmpty(subjects) ||
                Helper.isListNullorEmpty(preferredLanguages) ||
                Helper.isStringNullorEmpty(additionalNotes) ||
                Helper.isObjectNull(bookingStatus)

        ) {
            return null;

        }
        return new Booking.BookingBuilder()
                .setBookingDateTime(bookingDateTime)
                .setSessionDate(sessionDate)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setTutor(tutor)
                .setStudent(student)
                .setMode(bookingMode)
                .setDuration(duration)
                .setSubjects(subjects)
                .setPreferredLanguages(preferredLanguages)
                .setAdditionalNotes(additionalNotes)
                .setStatus(bookingStatus)
                .build();


    }
}
