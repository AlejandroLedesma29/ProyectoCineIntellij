package com.CineJUCO.CineJuco.Controladores;


import com.CineJUCO.CineJuco.Modelos.Funcion;
import com.CineJUCO.CineJuco.Modelos.Pelicula;
import com.CineJUCO.CineJuco.Modelos.Sala;
import com.CineJUCO.CineJuco.Repositorios.RepositorioFuncion;
import com.CineJUCO.CineJuco.Repositorios.RepositorioPelicula;
import com.CineJUCO.CineJuco.Repositorios.RepositorioSala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/funciones")
public class ControladorFuncion {

    @Autowired
        private RepositorioFuncion miRepositorioFuncion;

    @Autowired
    private RepositorioPelicula miRepositorioPelicula;

    @Autowired
    private RepositorioSala miRepositorioSala;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/pelicula/{id_pelicula}/sala/{id_sala}")
    public Funcion create(@RequestBody Funcion infoFuncion, @PathVariable String id_pelicula, @PathVariable String id_sala) {
        Pelicula PeliculaActual=this.miRepositorioPelicula
                .findById(id_pelicula)
                .orElseThrow(RuntimeException::new);
        Sala salaActual=this.miRepositorioSala
                .findById(id_sala)
                .orElseThrow(RuntimeException::new);
        infoFuncion.setPelicula(PeliculaActual);
        infoFuncion.setSala(salaActual);
        return this.miRepositorioFuncion.save(infoFuncion);
    }

    @GetMapping("")
    public List<Funcion> index(){
        return this.miRepositorioFuncion.findAll();
    }

    @GetMapping("{id}")
    public Funcion show(@PathVariable String id){
        Funcion funcionActual=this.miRepositorioFuncion
                .findById(id)
                .orElseThrow(RuntimeException::new);
        return funcionActual;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Funcion funcionActual=this.miRepositorioFuncion
                .findById(id)
                .orElseThrow(RuntimeException::new);
        this.miRepositorioFuncion.delete(funcionActual);
    }

    @PutMapping("{id}")
    public Funcion update(@PathVariable String id, @RequestBody Funcion infoFuncion){
        Funcion funcionActual=this.miRepositorioFuncion
                .findById(id)
                .orElseThrow(RuntimeException::new);
        funcionActual.setAno(infoFuncion.getAno());
        funcionActual.setDia(infoFuncion.getDia());
        funcionActual.setMes(infoFuncion.getMes());
        funcionActual.setHora(infoFuncion.getHora());
        return this.miRepositorioFuncion.save(funcionActual);
    }
}
