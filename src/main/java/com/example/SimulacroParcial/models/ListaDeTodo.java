package com.example.SimulacroParcial.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaDeTodo {
    private List<User> users;
    private List<Publication> publications;
    private List<Comentary> comentaries;
}
