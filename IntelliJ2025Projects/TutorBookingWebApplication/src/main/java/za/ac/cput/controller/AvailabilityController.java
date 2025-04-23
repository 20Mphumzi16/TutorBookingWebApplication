package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Availability;
import za.ac.cput.service.AvailabilityService.AvailabilityService;

import java.util.List;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    private AvailabilityService availabilityService;

    @Autowired
    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @PostMapping("/create")
    public Availability create(@RequestBody Availability availability) {
        return availabilityService.create(availability);
    }

    @GetMapping("/read/{id}")
    public Availability read(@PathVariable("id") Long id) {
        return availabilityService.read(id);
    }

    @PostMapping("/update")
    public Availability update(@RequestBody Availability availability) {
        return availabilityService.update(availability);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id) {
         return availabilityService.delete(id);
    }

    @GetMapping("/get-all")
    public List<Availability> getAll() {
        return availabilityService.getAll();
    }

}
