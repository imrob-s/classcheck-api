package com.imrob.classcheckapi.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_attendance")
public record Attendance(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        LocalDateTime dateTime,
        Student student,
        Course course
) {}
