package com.imrob.classcheckapi.repositories;

import com.imrob.classcheckapi.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
