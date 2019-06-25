package com.example.SimulacroParcial.services;

import com.example.SimulacroParcial.interfaces.ComentaryRepository;
import com.example.SimulacroParcial.interfaces.PublicationRepository;
import com.example.SimulacroParcial.interfaces.UserRepository;
import com.example.SimulacroParcial.models.Comentary;
import com.example.SimulacroParcial.models.Publication;
import com.example.SimulacroParcial.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ListaService {
    @Autowired
    CommentaryService commentaryService;

    @Autowired
    PublicationService publicationService;

    @Autowired
    UserService userService;

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<User>> getUsers() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(userService.getUsers());
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Publication>> getPublications() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(publicationService.getPublications());
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Comentary>> getComentaries() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(commentaryService.getCommentary());
    }


}
