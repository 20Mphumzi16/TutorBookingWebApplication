package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Education;
import za.ac.cput.service.EducationService.EducationService;

@RestController
@RequestMapping("/education")
public class EducationController {
    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping("/create")
    public Education create(@RequestBody Education education) {
        return educationService.create(education);
    }

}
