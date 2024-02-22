package com.imrob.classcheckapi.repositories;

import com.imrob.classcheckapi.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
