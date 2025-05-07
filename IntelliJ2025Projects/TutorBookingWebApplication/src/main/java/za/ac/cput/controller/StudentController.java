package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Student;
import za.ac.cput.service.StudentService.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @GetMapping("/read/{id}")
    public Student read(@PathVariable("id") Long id) {
        return studentService.read(id);
    }
    @PostMapping("/update")
    public Student update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return studentService.delete(id);
    }

    @GetMapping("/get-all")
    public List<Student> getAll() {
        return studentService.getAll();
    }
}
