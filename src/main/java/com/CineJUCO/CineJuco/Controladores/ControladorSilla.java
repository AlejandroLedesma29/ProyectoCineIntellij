package com.CineJUCO.CineJuco.Controladores;

import com.CineJUCO.CineJuco.Modelos.Boleto;
import com.CineJUCO.CineJuco.Modelos.Sala;
import com.CineJUCO.CineJuco.Modelos.Silla;
import com.CineJUCO.CineJuco.Repositorios.RepositorioBoleto;
import com.CineJUCO.CineJuco.Repositorios.RepositorioSala;
import com.CineJUCO.CineJuco.Repositorios.RepositorioSilla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/sillas")
public class ControladorSilla {
    @Autowired
    private RepositorioSilla miRepositorioSilla;

    @Autowired
    private RepositorioSala miRepositorioSala;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Silla create(@RequestBody Silla infoSilla) {
        return this.miRepositorioSilla.save(infoSilla);
    }

    @GetMapping("")
    public List<Silla> index(){
        return this.miRepositorioSilla.findAll();
    }

    @GetMapping("{id}")
    public Silla show(@PathVariable String id){
        Silla sillaActual=this.miRepositorioSilla
                .findById(id)
                .orElseThrow(RuntimeException::new);
        return sillaActual;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Silla sillaActual=this.miRepositorioSilla
                .findById(id)
                .orElseThrow(RuntimeException::new);
        this.miRepositorioSilla.delete(sillaActual);
    }

    @PutMapping("{id}")
    public Silla update(@PathVariable String id, @RequestBody Silla infoSilla){
        Silla sillaActual=this.miRepositorioSilla
                .findById(id)
                .orElseThrow(RuntimeException::new);
        sillaActual.setLetra(infoSilla.getLetra());
        sillaActual.setNumero(infoSilla.getNumero());
        return this.miRepositorioSilla.save(sillaActual);
    }


    @PutMapping("{id_silla}/sala/{id_sala}")
    public Silla updateSala(@PathVariable String id_silla, @PathVariable String id_sala){
        Silla sillaActual=this.miRepositorioSilla
                .findById(id_silla)
                .orElseThrow(RuntimeException::new);
        Sala salaActual=this.miRepositorioSala
                .findById(id_sala)
                .orElseThrow(RuntimeException::new);
        sillaActual.setSala(salaActual);
        return this.miRepositorioSilla.save(sillaActual);
    }
}
