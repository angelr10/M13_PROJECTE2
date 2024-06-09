package com.capokar.es.capokar.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capokar.es.capokar.Model.Trabajo;
import com.capokar.es.capokar.Repositories.ITrabajoRepository;

@Service
public class TrabajoService {
    @Autowired
    ITrabajoRepository trabajoRepository;

    public ArrayList<Trabajo> getTrabajos(){
        return(ArrayList<Trabajo>) this.trabajoRepository.findAll();
    }

    public Trabajo guardarTrabajo(Trabajo trabajo){
        return(Trabajo) this.trabajoRepository.save(trabajo);
    }

    public Optional<Trabajo> eliminarTrabajo(Long id){
        Optional<Trabajo> trabajoEliminado = this.trabajoRepository.findById(id);
        if(trabajoEliminado!=null){
            this.trabajoRepository.deleteById(id);
        }
        return(Optional<Trabajo>) trabajoEliminado;
    }

    public Optional<Trabajo> actualizarTrabajo(Trabajo trabajo,Long id){
        Optional<Trabajo> trabajoAntesDeActualizar = this.trabajoRepository.findById(id);
        if(trabajoAntesDeActualizar.isPresent()){
            Trabajo trabajoExistente = trabajoAntesDeActualizar.get();
            trabajoExistente.setTrabajadoresACargo(trabajo.getTrabajadoresACargo());
            trabajoExistente.setCosteTotalManoObra(trabajo.getCosteTotalManoObra());
            trabajoExistente.setEstado(trabajo.getEstado());
            trabajoExistente.setTiempo(trabajo.getTiempo());
            return Optional.of(trabajoExistente);
        }
        return Optional.empty();
    }
}
