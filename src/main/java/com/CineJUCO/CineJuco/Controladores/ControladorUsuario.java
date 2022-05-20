package com.CineJUCO.CineJuco.Controladores;

import com.CineJUCO.CineJuco.Modelos.Usuario;
import com.CineJUCO.CineJuco.Repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {

    @Autowired
    private RepositorioUsuario miRepositorioUsuario;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Usuario create(@RequestBody Usuario infoUsuario) {
        return this.miRepositorioUsuario.save(infoUsuario);
    }

    @GetMapping("")
    public List<Usuario> index(){
        return this.miRepositorioUsuario.findAll();
    }

    @GetMapping("{id}")
    public Usuario show(@PathVariable String id){
        Usuario usuarioActual=this.miRepositorioUsuario
                .findById(id)
                .orElseThrow(RuntimeException::new);
        return usuarioActual;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Usuario usuarioActual=this.miRepositorioUsuario
                .findById(id)
                .orElseThrow(RuntimeException::new);
        this.miRepositorioUsuario.delete(usuarioActual);
    }

    @PutMapping("{id}")
    public Usuario update(@PathVariable String id, @RequestBody Usuario infoUsuario){
        Usuario usuarioActual=this.miRepositorioUsuario
                .findById(id)
                .orElseThrow(RuntimeException::new);
        usuarioActual.setNombre(infoUsuario.getNombre());
        usuarioActual.setEmail(infoUsuario.getEmail());
        return this.miRepositorioUsuario.save(usuarioActual);
    }

    @GetMapping("/cedula/{cedula}")
    public Usuario buscarPorCedula(@PathVariable String cedula){
        Usuario usuarioActual=this.miRepositorioUsuario.getUsuarioPorCedula(cedula);
        return usuarioActual;
    }
}
