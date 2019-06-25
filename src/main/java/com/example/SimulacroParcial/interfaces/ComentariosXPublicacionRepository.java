package com.example.SimulacroParcial.interfaces;

import com.example.SimulacroParcial.models.ComentariosXPublicacionClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentariosXPublicacionRepository extends JpaRepository<ComentariosXPublicacionClass, String> {
    String NATIVE_QUERY = "select publication.title as title, user.name as dueno, count(comentary.id) as cantidad from publication inner join user on publication.id_user = user.id inner join comentary on publication.id = comentary.id_publication group by publication.title;";

    @Query(value = NATIVE_QUERY, nativeQuery = true)
    List<ComentariosXPublicacionClass> getComentariosXPublicacion();
}
