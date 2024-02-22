package com.imrob.classcheckapi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_course")
public record Course(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                     String id,
                     String name
                     ) { }
