package com.CineJUCO.CineJuco.Repositorios;

import com.CineJUCO.CineJuco.Modelos.Funcion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioFuncion extends MongoRepository<Funcion,String> {
}
