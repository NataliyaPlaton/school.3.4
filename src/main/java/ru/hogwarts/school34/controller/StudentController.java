package ru.hogwarts.school34.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school34.model.Student;
import ru.hogwarts.school34.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @GetMapping("{id}")
    public Student read(@PathVariable long id) {
        return studentService.read(id);
    }

    @PutMapping("{id}")
    public Student update(@PathVariable Long id,
                          @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @DeleteMapping("{id}")
    public Student delete(@PathVariable long id) {
        return studentService.delete(id);
    }


    @GetMapping
    public Collection<Student> findByAgeBetween(@RequestParam int min,
                                                @RequestParam int max) {
        return studentService.findByAgeBetween(min, max);
    }

}


