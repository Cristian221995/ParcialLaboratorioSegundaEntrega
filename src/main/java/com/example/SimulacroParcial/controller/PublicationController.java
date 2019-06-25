package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.interfaces.ComentariosXPublicacion;
import com.example.SimulacroParcial.interfaces.PublicationRepository;
import com.example.SimulacroParcial.interfaces.UserRepository;
import com.example.SimulacroParcial.models.ComentariosXPublicacionClass;
import com.example.SimulacroParcial.models.Publication;
import com.example.SimulacroParcial.models.User;
import com.example.SimulacroParcial.services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/publication")
public class PublicationController {

    @Autowired
    PublicationService publicationService;

    @PostMapping("/{id}")
    public void addPublication(@RequestBody Publication publication, @PathVariable("id") Integer id){
        publicationService.addPublication(publication,id);
    }

    @GetMapping("")
    public List<Publication> getPublications(){
        return publicationService.getPublications();
    }

    @GetMapping("/commentsByPublic")
    public List<ComentariosXPublicacion> getComentariosXPublicacion(){
        return publicationService.getComentariosXPublicacion();
    }

    @GetMapping("commentsByPublic2")
    public List<ComentariosXPublicacionClass> getComentariosXPublicacion2(){
        return publicationService.getComentariosXPublicacion2();
    }
}
