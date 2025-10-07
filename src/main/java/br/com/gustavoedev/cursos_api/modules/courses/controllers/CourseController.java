package br.com.gustavoedev.cursos_api.modules.courses.controllers;

import br.com.gustavoedev.cursos_api.modules.courses.dto.CourseCreateDTO;
import br.com.gustavoedev.cursos_api.modules.courses.entities.CourseEntity;
import br.com.gustavoedev.cursos_api.modules.courses.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.status(201).body(savedCourse);
    }

}
