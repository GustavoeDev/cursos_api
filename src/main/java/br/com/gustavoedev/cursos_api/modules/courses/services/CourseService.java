package br.com.gustavoedev.cursos_api.modules.courses.services;

import br.com.gustavoedev.cursos_api.modules.courses.CourseRepository;
import br.com.gustavoedev.cursos_api.modules.courses.dto.CourseCreateDTO;
import br.com.gustavoedev.cursos_api.modules.courses.entities.CourseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<CourseEntity> getAllCourses(String name, String category) {
        if (name != null && category != null) {
            return courseRepository.findByNameAndCategoryIgnoreCase(name, category);
        } else if (name != null) {
            return courseRepository.findByNameIgnoreCase(name);
        } else if (category != null) {
            return courseRepository.findByCategoryIgnoreCase(category);
        }
        return courseRepository.findAll();
    }


}
