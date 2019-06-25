package com.example.SimulacroParcial.services;

import com.example.SimulacroParcial.interfaces.ComentariosXPublicacion;
import com.example.SimulacroParcial.interfaces.ComentariosXPublicacionRepository;
import com.example.SimulacroParcial.interfaces.PublicationRepository;
import com.example.SimulacroParcial.interfaces.UserRepository;
import com.example.SimulacroParcial.models.ComentariosXPublicacionClass;
import com.example.SimulacroParcial.models.Publication;
import com.example.SimulacroParcial.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PublicationService {
    @Autowired
    PublicationRepository publicationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ComentariosXPublicacionRepository comentariosXPublicacionRepository;

    public void addPublication(@RequestBody Publication publication, @PathVariable("id") Integer id){
        User user = userRepository.getOne(id);
        publication.setUser(user);

        publication.setPublicationDate(LocalDateTime.now());
        publicationRepository.save(publication);
    }

    public List<Publication> getPublications(){
        return publicationRepository.findAll();
    }

    public List<ComentariosXPublicacion> getComentariosXPublicacion(){
        return publicationRepository.getComentariosXPublicacion();
    }

    public List<ComentariosXPublicacionClass> getComentariosXPublicacion2(){
        return comentariosXPublicacionRepository.getComentariosXPublicacion();
    }

}
