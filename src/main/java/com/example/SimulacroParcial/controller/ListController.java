package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.models.Comentary;
import com.example.SimulacroParcial.models.ListaDeTodo;
import com.example.SimulacroParcial.models.Publication;
import com.example.SimulacroParcial.models.User;
import com.example.SimulacroParcial.services.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/list")
public class ListController {
    @Autowired
    ListaService listaService;

    @GetMapping("/allContent")
    public ResponseEntity<ListaDeTodo> getAll() {
        CompletableFuture<List<User>> users = listaService.getUsers();
        CompletableFuture<List<Publication>> publications = listaService.getPublications();
        CompletableFuture<List<Comentary>> comentaries = listaService.getComentaries();

        ListaDeTodo lista = new ListaDeTodo(users.join(),publications.join(),comentaries.join());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista);
    }

}
