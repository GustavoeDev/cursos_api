package br.com.gustavoedev.cursos_api.modules.courses.controllers;

import br.com.gustavoedev.cursos_api.modules.courses.dto.CourseCreateDTO;
import br.com.gustavoedev.cursos_api.modules.courses.dto.CourseUpdateDTO;
import br.com.gustavoedev.cursos_api.modules.courses.entities.CourseEntity;
import br.com.gustavoedev.cursos_api.modules.courses.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseEntity> createCourse(@Valid @RequestBody CourseCreateDTO courseDTO) {
        CourseEntity savedCourse = this.courseService.courseCreate(courseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
    }

    @GetMapping
    public ResponseEntity<List<CourseEntity>> getCourses(@RequestParam(required = false) String name,
                                                         @RequestParam(required = false) String category) {

        List<CourseEntity> courses = courseService.getAllCourses(name, category);
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseEntity> updateCourse(@PathVariable UUID id, @Valid @RequestBody CourseUpdateDTO courseDTO) {
        CourseEntity updatedCourse = courseService.updateCourse(id, courseDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable UUID id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
