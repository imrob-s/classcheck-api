package com.imrob.classcheckapi.services;

import com.imrob.classcheckapi.dto.CourseDTO;
import com.imrob.classcheckapi.dto.StudentDTO;
import com.imrob.classcheckapi.entities.Course;
import com.imrob.classcheckapi.entities.Student;
import com.imrob.classcheckapi.exceptions.DatabaseException;
import com.imrob.classcheckapi.exceptions.ResourceNotFoundException;
import com.imrob.classcheckapi.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    @Transactional(readOnly = true)
    public CourseDTO findById(Long id) {
        Course course = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new CourseDTO(course);
    }
    @Transactional(readOnly = true)
    public Page<CourseDTO> findAll(Pageable pageable) {
        Page<Course> products = repository.findAll(pageable);
        return products.map(CourseDTO::new);
    }

    @Transactional
    public CourseDTO insert(CourseDTO dto) {
        Course entity = new Course();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new CourseDTO(entity);
    }

    @Transactional
    public CourseDTO update(Long id, CourseDTO dto) {
        try {
            Course entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new CourseDTO(entity);
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


    private void copyDtoToEntity(CourseDTO dto, Course entity) {
        entity.setId(dto.id());
        entity.setName(dto.name());
    }
}
