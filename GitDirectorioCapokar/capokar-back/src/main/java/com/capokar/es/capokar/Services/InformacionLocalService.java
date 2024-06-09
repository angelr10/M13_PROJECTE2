package com.capokar.es.capokar.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capokar.es.capokar.Model.Empleado;
import com.capokar.es.capokar.Model.InformacionLocal;
import com.capokar.es.capokar.Repositories.IEmpleadoRepository;
import com.capokar.es.capokar.Repositories.IinformacionLocalRepository;

@Service
public class InformacionLocalService {
    @Autowired
    IinformacionLocalRepository informacionLocalRepository;

    @Autowired
    IEmpleadoRepository empleadoRepository;

    public ArrayList<InformacionLocal> getInformacionLocal(){
        return(ArrayList<InformacionLocal>) this.informacionLocalRepository.findAll();
    }

    public InformacionLocal guardarInformacionLocal(InformacionLocal informacionLocal){
        Empleado empleado = empleadoRepository.findById(informacionLocal.getEmpleado().getId_empleado()).orElse(null);
        if(empleado != null){
            informacionLocal.setNombre_representante(empleado.getNombre());
            informacionLocal.setApellido_representante(empleado.getApellido());
        }
        return(InformacionLocal) this.informacionLocalRepository.save(informacionLocal);
    }

    public Optional<InformacionLocal> eliminarInformacionLocal(Long id){
        Optional<InformacionLocal> informacionLocalEliminado = informacionLocalRepository.findById(id);
        if(informacionLocalEliminado.isPresent()){
            informacionLocalRepository.deleteById(id);
        }
        return informacionLocalEliminado;
    }

}
