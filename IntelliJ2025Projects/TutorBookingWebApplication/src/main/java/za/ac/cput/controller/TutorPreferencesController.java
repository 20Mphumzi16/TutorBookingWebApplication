package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.TutorPreferences;
import za.ac.cput.service.TutorPreferenceService.TutorPreferencesService;

import java.util.List;

@RestController
@RequestMapping("/tutor-preferences")
public class TutorPreferencesController {
    private TutorPreferencesService tutorPreferencesService;

    @Autowired
    public TutorPreferencesController(TutorPreferencesService tutorPreferencesService) {
        this.tutorPreferencesService = tutorPreferencesService;
    }

    @PostMapping("/create")
    public TutorPreferences create(@RequestBody TutorPreferences tutorPreferences) {
        return tutorPreferencesService.create(tutorPreferences);
    }

    @GetMapping("/read/{id}")
    public TutorPreferences read(@PathVariable("id") Long id) {
        return tutorPreferencesService.read(id);
    }

    @PostMapping("/update")
    public TutorPreferences update(@RequestBody TutorPreferences tutorPreferences) {
        return tutorPreferencesService.update(tutorPreferences);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return tutorPreferencesService.delete(id);
    }

    @GetMapping("get-all")
    public List<TutorPreferences> getAll() {
        return tutorPreferencesService.getAll();
    }


}
