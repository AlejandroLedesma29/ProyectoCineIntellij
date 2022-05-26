package com.CineJUCO.CineJuco.Controladores;

import com.CineJUCO.CineJuco.Modelos.*;
import com.CineJUCO.CineJuco.Repositorios.RepositorioBoleto;
import com.CineJUCO.CineJuco.Repositorios.RepositorioFuncion;
import com.CineJUCO.CineJuco.Repositorios.RepositorioSilla;
import com.CineJUCO.CineJuco.Repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/boletos")
public class ControladorBoleto {
    @Autowired
    RepositorioBoleto miRepositorioBoleto;

    @Autowired
    RepositorioUsuario miRepositorioUsuario;

    @Autowired
    RepositorioFuncion miRepositorioFuncion;

    @Autowired
    RepositorioSilla miRepositorioSilla;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Boleto create(@RequestBody Boleto infoBoleto) {
        return this.miRepositorioBoleto.save(infoBoleto);
    }

    @GetMapping("")
    public List<Boleto> index(){
        return this.miRepositorioBoleto.findAll();
    }

    @GetMapping("{id}")
    public Boleto show(@PathVariable String id){
        Boleto boletoActual=this.miRepositorioBoleto
                .findById(id)
                .orElseThrow(RuntimeException::new);
        return boletoActual;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Boleto boletoActual=this.miRepositorioBoleto
                .findById(id)
                .orElseThrow(RuntimeException::new);
        this.miRepositorioBoleto.delete(boletoActual);
    }

    @PutMapping("{id}")
    public Boleto update(@PathVariable String id, @RequestBody Boleto infoCurso){
        Boleto boletoActual=this.miRepositorioBoleto
                .findById(id)
                .orElseThrow(RuntimeException::new);
        boletoActual.setValor(infoCurso.getValor());
        boletoActual.setTipo(infoCurso.getTipo());
        return this.miRepositorioBoleto.save(boletoActual);
    }

    @PutMapping("{id_boleto}/usuario/{id_usuario}")
    public Boleto updateUsuario(@PathVariable String id_boleto, @PathVariable String id_usuario){
        Boleto boletoActual=this.miRepositorioBoleto
                .findById(id_boleto)
                .orElseThrow(RuntimeException::new);
        Usuario UsuarioActual=this.miRepositorioUsuario
                .findById(id_usuario)
                .orElseThrow(RuntimeException::new);
        boletoActual.setUsuario(UsuarioActual);
        return this.miRepositorioBoleto.save(boletoActual);
    }

    @PutMapping("{id_boleto}/funcion/{id_funcion}")
    public Boleto updateFuncion(@PathVariable String id_boleto, @PathVariable String id_funcion){
        Boleto boletoActual=this.miRepositorioBoleto
                .findById(id_boleto)
                .orElseThrow(RuntimeException::new);
        Funcion funcionActual=this.miRepositorioFuncion
                .findById(id_funcion)
                .orElseThrow(RuntimeException::new);
        boletoActual.setFuncion(funcionActual);
        return this.miRepositorioBoleto.save(boletoActual);
    }

    @PutMapping("{id_boleto}/silla/{id_silla}")
    public Boleto updateSilla(@PathVariable String id_boleto, @PathVariable String id_silla){
        Boleto boletoActual=this.miRepositorioBoleto
                .findById(id_boleto)
                .orElseThrow(RuntimeException::new);
        Silla sillaActual=this.miRepositorioSilla
                .findById(id_silla)
                .orElseThrow(RuntimeException::new);
        boletoActual.setSilla(sillaActual);
        return this.miRepositorioBoleto.save(boletoActual);
    }
}
