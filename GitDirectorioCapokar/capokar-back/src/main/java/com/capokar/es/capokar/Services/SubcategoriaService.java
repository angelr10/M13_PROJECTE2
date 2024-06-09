package com.capokar.es.capokar.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capokar.es.capokar.Model.Subcategoria;

import com.capokar.es.capokar.Repositories.ISubcategoriaRepository;

@Service
public class SubcategoriaService {
    @Autowired
    ISubcategoriaRepository subcategoriaRepository;

    public ArrayList<Subcategoria> getSubcategorias(){
        return(ArrayList<Subcategoria>) subcategoriaRepository.findAll();
    }

    public Subcategoria guardarSubcategoria(Subcategoria subcategoria){
        return(Subcategoria) subcategoriaRepository.save(subcategoria);
    }

    public Optional<Subcategoria> eliminarSubcategoria(Long id){
        Optional<Subcategoria> subcategoriaEliminada = subcategoriaRepository.findById(id);
        if(subcategoriaEliminada != null){
            subcategoriaRepository.deleteById(id);
        }
        return subcategoriaEliminada;
    }
}
