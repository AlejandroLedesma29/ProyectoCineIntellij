package com.CineJUCO.CineJuco.Repositorios;

import com.CineJUCO.CineJuco.Modelos.Pelicula;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPelicula extends MongoRepository<Pelicula,String> {
}
