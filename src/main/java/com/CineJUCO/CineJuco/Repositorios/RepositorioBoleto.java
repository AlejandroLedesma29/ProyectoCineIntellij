package com.CineJUCO.CineJuco.Repositorios;

import com.CineJUCO.CineJuco.Modelos.Boleto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioBoleto extends MongoRepository<Boleto,String> {
}
