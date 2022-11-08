package ru.hogwarts.school34.service;

import org.springframework.stereotype.Service;


import ru.hogwarts.school34.exception.StudentNotFoundException;

import ru.hogwarts.school34.model.Faculty;
import ru.hogwarts.school34.model.Student;
import ru.hogwarts.school34.repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(Student student) {
        student.setId(null);
        return studentRepository.save(student);

    }

    public Student read(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }


    public Student update(long id, Student newStudent) {
        Student oldStudent = read(id);
        oldStudent.setAge(newStudent.getAge());
        oldStudent.setName(newStudent.getName());
        return studentRepository.save(oldStudent);
    }


    public Student delete(long id) {
        Student student = read(id);
        studentRepository.delete(student);
        return student;
    }

    public Collection<Student> findByAge(int age) {
        return studentRepository.findAllByAge(age);
    }

    public Collection<Student> findByAgeBetween(int min, int max) {
        if (min < 0 || max < 0 || max < min) {
            throw new IllegalArgumentException();
        }
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty getNumberFacultyOfStudent(long student_id) {
        return studentRepository.findById(student_id).get().getFaculty();
    }
}



