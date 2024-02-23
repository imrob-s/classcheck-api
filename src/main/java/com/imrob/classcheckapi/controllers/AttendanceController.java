package com.imrob.classcheckapi.controllers;

import com.imrob.classcheckapi.dto.AttendanceDTO;
import com.imrob.classcheckapi.services.AttendanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
@RestController
@RequestMapping(value = "/attendances")
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AttendanceDTO> findById(@PathVariable Long id) {
        AttendanceDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<AttendanceDTO>> findAll(Pageable pageable) {
        Page<AttendanceDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AttendanceDTO> insert(@Valid @RequestBody AttendanceDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AttendanceDTO> update(@PathVariable Long id, @Valid @RequestBody AttendanceDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
