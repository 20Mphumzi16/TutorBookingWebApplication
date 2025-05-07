package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Language;
import za.ac.cput.service.LanguageService.LanguageService;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/create")
    public Language save(@RequestBody Language language) {
        return languageService.create(language);
    }
    @GetMapping("/read/{id}")
    public Language read(@PathVariable("id") Long id) {
        return languageService.read(id);
    }

    @PostMapping("/update")
    public Language update(@RequestBody Language language) {
        return languageService.update(language);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return languageService.delete(id);
    }
    @GetMapping("/get-all")
    public List<Language> getAll() {
        return languageService.getAll();
    }
}
