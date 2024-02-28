package com.imrob.classcheckapi.services;

import com.imrob.classcheckapi.dto.AttendanceDTO;
import com.imrob.classcheckapi.entities.Attendance;
import com.imrob.classcheckapi.entities.Course;
import com.imrob.classcheckapi.entities.Student;
import com.imrob.classcheckapi.exceptions.DatabaseException;
import com.imrob.classcheckapi.exceptions.ResourceNotFoundException;
import com.imrob.classcheckapi.repositories.AttendanceRepository;
import com.imrob.classcheckapi.repositories.CourseRepository;
import com.imrob.classcheckapi.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository repository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public AttendanceDTO findById(Long id) {
        Attendance attendance = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new AttendanceDTO(attendance);
    }
    @Transactional(readOnly = true)
    public Page<AttendanceDTO> findAll(Pageable pageable) {
        Page<Attendance> products = repository.findAll(pageable);
        return products.map(AttendanceDTO::new);
    }

    @Transactional
    public AttendanceDTO insert(AttendanceDTO dto) {
        Attendance entity = new Attendance();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new AttendanceDTO(entity);
    }

    @Transactional
    public AttendanceDTO update(Long id, AttendanceDTO dto) {
        try {
            Attendance entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new AttendanceDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("O ID %d não foi encontrado".formatted(id));
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }


    private void copyDtoToEntity(AttendanceDTO dto, Attendance entity) {
        entity.setId(dto.id());
        entity.setDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        Student student = studentRepository.findById(dto.studentId())
                .orElseThrow(() -> new ResourceNotFoundException("Aluno com id %d não foi encontrado"
                .formatted(dto.studentId())));
        entity.setStudent(student);
        Course course = courseRepository.findById(dto.courseId())
                .orElseThrow(() -> new ResourceNotFoundException("Materia com id %d não foi encontrado"
                .formatted(dto.courseId())));
        entity.setCourse(course);
    }
}
