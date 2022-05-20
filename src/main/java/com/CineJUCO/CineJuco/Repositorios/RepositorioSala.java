package com.CineJUCO.CineJuco.Repositorios;

import com.CineJUCO.CineJuco.Modelos.Sala;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioSala extends MongoRepository<Sala,String> {
}
