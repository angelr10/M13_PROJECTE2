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

import com.capokar.es.capokar.Model.Subcategoria;
import com.capokar.es.capokar.Services.SubcategoriaService;

@RestController
@RequestMapping("/subcategorias")
public class SubcategoriaController {
    @Autowired
    SubcategoriaService subcategoriaService;

    @GetMapping("/mostrarSubcategorias")
    public ArrayList<Subcategoria> getSubcategorias(){
        return this.subcategoriaService.getSubcategorias();
    }

    @PostMapping("/guardarSubcategoria")
    public Subcategoria guardarSubcategoria(@RequestBody Subcategoria subcategoria){
        return this.subcategoriaService.guardarSubcategoria(subcategoria);
    }

    @DeleteMapping("/eliminarSubcategoriaID/{id}")
    public Optional<Subcategoria> eliminarSubcategoriaPorId(@PathVariable Long id){
        return this.subcategoriaService.eliminarSubcategoria(id);
    }
}
