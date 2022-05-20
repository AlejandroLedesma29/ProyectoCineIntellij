package com.CineJUCO.CineJuco.Repositorios;

import com.CineJUCO.CineJuco.Modelos.Silla;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioSilla extends MongoRepository<Silla,String> {
}
