package ru.hogwarts.school34.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school34.model.Faculty;
import ru.hogwarts.school34.service.FacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty create(@RequestBody Faculty faculty) {
        return facultyService.create(faculty);
    }

    @GetMapping("{id}")
    public Faculty read(@PathVariable long id) {
        return facultyService.read(id);
    }

    @PutMapping("{id}")
    public Faculty update(@PathVariable Long id,
                          @RequestBody Faculty faculty) {
        return facultyService.update(id, faculty);
    }

    @DeleteMapping("{id}")
    public Faculty delete(@PathVariable long id) {
        return facultyService.delete(id);
    }


    @GetMapping
    public Faculty findByNameOrColor(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) String color) {
        return facultyService.findByNameOrColor(name, color);
    }

}

