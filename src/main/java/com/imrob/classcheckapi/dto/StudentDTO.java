package com.imrob.classcheckapi.dto;

import com.imrob.classcheckapi.entities.Student;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CPF;

public record StudentDTO(Long id,
                         @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres")
                         @NotBlank(message = "Campo requerido")
                         String name,
                         @CPF
                         @NotBlank(message = "Campo requerido")
                         @Column(unique = true)
                         String cpf,
                         String phoneNumber,
                         @Email
                         @Column(unique = true)
                         String email,
                         @URL
                         String github,
                         @URL
                         String imgUrl) {
    public StudentDTO(Student student){
        this(student.getId(),
             student.getName(),
             student.getCpf(),
             student.getPhoneNumber(),
             student.getEmail(),
             student.getGithub(),
             student.getImgUrl());
    }
}
