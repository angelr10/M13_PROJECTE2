package com.capokar.es.capokar.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capokar.es.capokar.Model.Empleado;
import com.capokar.es.capokar.Repositories.IEmpleadoRepository;

@Service
public class EmpleadoService{
    @Autowired
    IEmpleadoRepository empleadoRepository;

    public ArrayList<Empleado> getEmpleados(){
        return(ArrayList<Empleado>) this.empleadoRepository.findAll();
    }

    public Empleado guardarEmpleado(Empleado empleado){
        return(Empleado) empleadoRepository.save(empleado);
    }

    public Optional<Empleado> eliminarEmpleado(Long id){
        Optional<Empleado> empleadoEliminado = empleadoRepository.findById(id);
        if(empleadoEliminado.isPresent()){
            empleadoRepository.deleteById(id);
        }
        return empleadoEliminado;
    }
}