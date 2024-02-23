package com.imrob.classcheckapi.services;

import com.imrob.classcheckapi.dto.AttendanceDTO;
import com.imrob.classcheckapi.entities.Attendance;
import com.imrob.classcheckapi.exceptions.ResourceNotFoundException;
import com.imrob.classcheckapi.repositories.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository repository;

    @Transactional(readOnly = true)
    public AttendanceDTO findById(Long id) {
        Attendance attendance = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new AttendanceDTO(attendance);
    }
}
