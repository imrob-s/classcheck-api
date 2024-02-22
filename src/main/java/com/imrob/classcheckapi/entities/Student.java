package com.imrob.classcheckapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_student")
public record Student(@Id
                      Long id,
                      String name,
                      String cpf,
                      String phoneNumber,
                      String email,
                      String github,
                      String imgUrl
) {}
