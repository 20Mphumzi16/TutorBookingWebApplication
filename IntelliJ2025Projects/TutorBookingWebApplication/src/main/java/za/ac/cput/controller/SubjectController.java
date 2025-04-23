package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Subject;
import za.ac.cput.service.SubjectService.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/create")
    public Subject create(@RequestBody Subject subject) {
        return subjectService.create(subject);
    }

    @GetMapping("/read/{id}")
    public Subject read(@PathVariable("id") Long id) {
        return subjectService.read(id);
    }

    @PostMapping("/update")
    public Subject update(@RequestBody Subject subject) {
        return subjectService.update(subject);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return subjectService.delete(id);
    }
    @GetMapping("/get-all")
    public List<Subject> getAll() {
        return subjectService.getAll();
    }
}
