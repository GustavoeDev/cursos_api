package br.com.gustavoedev.cursos_api.modules.courses;

import br.com.gustavoedev.cursos_api.modules.courses.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
}
