package com.CineJUCO.CineJuco.Controladores;

import com.CineJUCO.CineJuco.Modelos.Sala;
import com.CineJUCO.CineJuco.Repositorios.RepositorioSala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/salas")
public class ControladorSala {
    @Autowired
    private RepositorioSala miRepositorioSala;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Sala create(@RequestBody Sala infoSala) {
        return this.miRepositorioSala.save(infoSala);
    }

    @GetMapping("")
    public List<Sala> index(){
        return this.miRepositorioSala.findAll();
    }

    @GetMapping("{id}")
    public Sala show(@PathVariable String id){
        Sala salaActual=this.miRepositorioSala
                .findById(id)
                .orElseThrow(RuntimeException::new);
        return salaActual;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Sala salaActual=this.miRepositorioSala
                .findById(id)
                .orElseThrow(RuntimeException::new);
        this.miRepositorioSala.delete(salaActual);
    }

    @PutMapping("{id}")
    public Sala update(@PathVariable String id, @RequestBody Sala infoSala){
        Sala salaActual=this.miRepositorioSala
                .findById(id)
                .orElseThrow(RuntimeException::new);
        salaActual.setNombre(infoSala.getNombre());
        salaActual.setEfectosEspeciales(infoSala.isEfectosEspeciales());
        return this.miRepositorioSala.save(salaActual);
    }
}
