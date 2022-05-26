package com.CineJUCO.CineJuco.Repositorios;

import com.CineJUCO.CineJuco.Modelos.Pelicula;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RepositorioPelicula extends MongoRepository<Pelicula,String> {
    @Query("{'nombre': ?0}")
    public Pelicula getPeliculaPorNombre(String nombre);
}
