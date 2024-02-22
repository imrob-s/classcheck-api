package com.imrob.classcheckapi.dto;

import com.imrob.classcheckapi.entities.Course;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CourseDTO(String id,
                        @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres")
                        @NotBlank(message = "Campo requerido")
                        String name) {
    public CourseDTO(Course entity){
        this(entity.id(), entity.name());
    }
}
