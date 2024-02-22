package com.imrob.classcheckapi.repositories;

import com.imrob.classcheckapi.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
