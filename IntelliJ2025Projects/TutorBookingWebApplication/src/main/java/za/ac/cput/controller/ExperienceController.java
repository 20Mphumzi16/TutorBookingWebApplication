package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Experience;
import za.ac.cput.service.ExperienceService.ExperienceService;

import java.util.List;

@RestController
@RequestMapping("/experience")
public class ExperienceController {

    private  ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService=experienceService;
    }

    @PostMapping("/create")
    public Experience create(@RequestBody Experience experience) {
        return experienceService.create(experience);
    }

    @GetMapping("/read/{id}")
    public Experience read(@PathVariable("id") Long id) {
        return experienceService.read(id);
    }

    @PostMapping("/update")
    public Experience update(@RequestBody Experience experience) {
        return experienceService.update(experience);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return experienceService.delete(id);
    }

    @GetMapping("/get-all")
    public List<Experience> getAll() {
        return experienceService.getAll();
    }
}
