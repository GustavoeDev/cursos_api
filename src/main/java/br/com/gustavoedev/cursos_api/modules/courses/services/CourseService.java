package br.com.gustavoedev.cursos_api.modules.courses.services;

import br.com.gustavoedev.cursos_api.modules.courses.CourseRepository;
import br.com.gustavoedev.cursos_api.modules.courses.dto.CourseCreateDTO;
import br.com.gustavoedev.cursos_api.modules.courses.entities.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseEntity courseCreate(CourseCreateDTO courseDTO) {
        CourseEntity course = new CourseEntity();
        course.setName(courseDTO.getName());
        course.setCategory(courseDTO.getCategory());

        return courseRepository.save(course);
    }

}
