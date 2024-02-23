package com.imrob.classcheckapi.services;

import com.imrob.classcheckapi.dto.AttendanceDTO;
import com.imrob.classcheckapi.dto.StudentDTO;
import com.imrob.classcheckapi.entities.Attendance;
import com.imrob.classcheckapi.entities.Course;
import com.imrob.classcheckapi.entities.Student;
import com.imrob.classcheckapi.exceptions.DatabaseException;
import com.imrob.classcheckapi.exceptions.ResourceNotFoundException;
import com.imrob.classcheckapi.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    @Transactional(readOnly = true)
    public StudentDTO findById(Long id) {
        Student student = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new StudentDTO(student);
    }
    @Transactional(readOnly = true)
    public Page<StudentDTO> findAll(Pageable pageable) {
        Page<Student> products = repository.findAll(pageable);
        return products.map(StudentDTO::new);
    }

    @Transactional
    public StudentDTO insert(StudentDTO dto) {
        Student entity = new Student();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new StudentDTO(entity);
    }

    @Transactional
    public StudentDTO update(Long id, StudentDTO dto) {
        try {
            Student entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new StudentDTO(entity);
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


    private void copyDtoToEntity(StudentDTO dto, Student entity) {
        entity.setId(dto.id());
        entity.setName(dto.name());
        entity.setCpf(dto.cpf());
        entity.setPhoneNumber(dto.phoneNumber());
        entity.setEmail(dto.email());
        entity.setGithub(dto.github());
        entity.setImgUrl(dto.imgUrl());
    }
}
