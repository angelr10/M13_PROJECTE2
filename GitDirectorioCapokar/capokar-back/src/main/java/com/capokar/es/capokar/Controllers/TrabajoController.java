package com.capokar.es.capokar.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capokar.es.capokar.Model.Trabajo;
import com.capokar.es.capokar.Services.TrabajoService;

@RestController
@RequestMapping("/trabajos")
public class TrabajoController {
    @Autowired
    TrabajoService trabajoService;

    @GetMapping("/mostrarTrabajos")
    public ArrayList<Trabajo> getTrabajos(){
        return this.trabajoService.getTrabajos();
    }

    @PostMapping("/guardarTrabajo")
    public Trabajo guardarTrabajo(@RequestBody Trabajo trabajo){
        return this.trabajoService.guardarTrabajo(trabajo);
    }

    @DeleteMapping("/eliminarTrabajoID/{id}")
    public Optional<Trabajo> eliminarVehiculoPorId(@PathVariable Long id){
        Optional<Trabajo> eliminado = this.trabajoService.eliminarTrabajo(id);
        return eliminado;
    }
}
