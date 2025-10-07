package br.com.gustavoedev.cursos_api.modules.courses.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreateDTO {

    @NotBlank(message = "O nome do curso é obrigatório")
    private String name;

    @NotBlank(message = "O categoria do curso é obrigatória")
    private String category;

}
