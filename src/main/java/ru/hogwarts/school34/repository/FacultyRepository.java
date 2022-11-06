package ru.hogwarts.school34.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school34.model.Faculty;


@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Faculty findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);


}
