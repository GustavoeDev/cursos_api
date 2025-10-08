package br.com.gustavoedev.cursos_api.modules.courses.controllers;

import br.com.gustavoedev.cursos_api.modules.courses.dto.CourseCreateDTO;
import br.com.gustavoedev.cursos_api.modules.courses.entities.CourseEntity;
import br.com.gustavoedev.cursos_api.modules.courses.services.CourseService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
