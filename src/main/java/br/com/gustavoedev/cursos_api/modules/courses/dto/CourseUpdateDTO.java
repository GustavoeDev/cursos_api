package br.com.gustavoedev.cursos_api.modules.courses.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseUpdateDTO {

    private String name;
    private String category;

}
