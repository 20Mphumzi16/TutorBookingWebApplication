package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Booking;
import za.ac.cput.service.BookingService.BookingService;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public Booking create(@RequestBody Booking booking) {
        return bookingService.create(booking);
    }

    @GetMapping("/read/{id}")
    public Booking read(@PathVariable("id") Long id) {
        return bookingService.read(id);

    }

    @PostMapping("/update")
    public Booking update(@RequestBody Booking booking) {
        return bookingService.update(booking);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return bookingService.delete(id);
    }

    @GetMapping("/get-all")
    public List<Booking> getAll() {
        return bookingService.getAll();
    }



}
