package com.imrob.classcheckapi.dto;

import com.imrob.classcheckapi.entities.Attendance;
import com.imrob.classcheckapi.entities.Course;
import com.imrob.classcheckapi.entities.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AttendanceDTO(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        LocalDateTime dateTime,
        @NotNull
        Long studentId,
        @NotNull
        Long courseId
        ) {
    public AttendanceDTO(Attendance entity){
        this(entity.getId(),
             entity.getDateTime(),
             entity.getStudent().getId(),
             entity.getCourse().getId());
    }
}
