package ru.hogwarts.school34.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school34.model.Faculty;
import ru.hogwarts.school34.model.Student;
import ru.hogwarts.school34.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
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
    public ResponseEntity<Student> read(@PathVariable long id) {
        Student student = studentService.read(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> update(@PathVariable Long id,
                                          @RequestBody Student student) {
        Student foundStudent = studentService.update(id, student);
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> delete(@PathVariable long id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Collection<Student> findByAgeBetween(@RequestParam int min,
                                                @RequestParam int max) {
        return studentService.findByAgeBetween(min, max);

    }

    @GetMapping("facultyOfStudent")
    public Faculty getNumberFacultyOfStudent(@RequestParam long id) {
        return studentService.getNumberFacultyOfStudent(id);
    }
}


