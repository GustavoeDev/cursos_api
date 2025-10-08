package br.com.gustavoedev.cursos_api.modules.courses.services;

import br.com.gustavoedev.cursos_api.modules.courses.CourseRepository;
import br.com.gustavoedev.cursos_api.modules.courses.dto.CourseCreateDTO;
import br.com.gustavoedev.cursos_api.modules.courses.dto.CourseUpdateDTO;
import br.com.gustavoedev.cursos_api.modules.courses.entities.CourseActiveENUM;
import br.com.gustavoedev.cursos_api.modules.courses.entities.CourseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public CourseEntity updateCourse(UUID id, CourseUpdateDTO courseDTO) {
        CourseEntity course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado!"));

        if (courseDTO.getName() != null) {
            course.setName(courseDTO.getName());
        }

        if (courseDTO.getCategory() != null) {
            course.setCategory(courseDTO.getCategory());
        }

        return courseRepository.save(course);
    }

    public void deleteCourse(UUID id) {
        CourseEntity course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado!"));
        courseRepository.delete(course);
    }

    public CourseEntity activateCourse(UUID id) {
        CourseEntity course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado!"));

        CourseActiveENUM currentStatus = course.getStatus();
        if (currentStatus == CourseActiveENUM.ACTIVE) {
            course.setStatus(CourseActiveENUM.INACTIVE);
        } else {
            course.setStatus(CourseActiveENUM.ACTIVE);
        }

        return courseRepository.save(course);
    }


}
