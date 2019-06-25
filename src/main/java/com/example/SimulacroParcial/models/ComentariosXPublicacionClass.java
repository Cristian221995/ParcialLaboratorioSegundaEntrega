package com.example.SimulacroParcial.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ComentariosXPublicacionClass {
    @Id
    private String title;
    private String dueno;
    private Integer cantidad;
}
