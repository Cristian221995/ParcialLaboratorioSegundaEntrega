package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.models.Comentary;
import com.example.SimulacroParcial.services.CommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/commentary")
public class ComentaryController {

    @Autowired
    CommentaryService commentaryService;

    @PostMapping("/{id}/{idUsuario}")
    public void addComentary(@RequestBody Comentary comentary, @PathVariable("id") Integer id, @PathVariable("idUsuario") Integer idUsuario) {
        commentaryService.addComentary(comentary, id, idUsuario);
    }

    @GetMapping("")
    public List<Comentary> getCommentary() {
        return commentaryService.getCommentary();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComentary(@PathVariable("id") Integer id) {
        commentaryService.deleteComentary(id);
    }

}
