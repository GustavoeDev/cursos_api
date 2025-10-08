package br.com.gustavoedev.cursos_api.modules.courses;

import br.com.gustavoedev.cursos_api.modules.courses.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
    @Query("SELECT c FROM CourseEntity c WHERE " +
            "LOWER(REPLACE(c.name, ' ', '')) = LOWER(REPLACE(:name, ' ', ''))")
    List<CourseEntity> findByNameIgnoreCase(@Param("name") String name);

    @Query("SELECT c FROM CourseEntity c WHERE " +
            "LOWER(REPLACE(c.category, ' ', '')) = LOWER(REPLACE(:category, ' ', ''))")
    List<CourseEntity> findByCategoryIgnoreCase(@Param("category") String category);

    @Query("SELECT c FROM CourseEntity c WHERE " +
            "LOWER(REPLACE(c.name, ' ', '')) = LOWER(REPLACE(:name, ' ', '')) AND " +
            "LOWER(REPLACE(c.category, ' ', '')) = LOWER(REPLACE(:category, ' ', ''))")
    List<CourseEntity> findByNameAndCategoryIgnoreCase(@Param("name") String name,
                                                       @Param("category") String category);
}
