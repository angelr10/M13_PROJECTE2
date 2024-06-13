package com.capokar.es.capokar.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capokar.es.capokar.Model.Factura;
import com.capokar.es.capokar.Model.Vehiculo;
import com.capokar.es.capokar.Repositories.IFacturaRepository;
import com.capokar.es.capokar.Repositories.IVehiculoRepository;

@Service
public class VehiculoService {
    @Autowired
    IVehiculoRepository vehiculoRepository;

    @Autowired
    IFacturaRepository facturaRepository;

    public ArrayList<Vehiculo> getVehiculos(){
        return(ArrayList<Vehiculo>) vehiculoRepository.findAll();
    }

    public Vehiculo guardarVehiculo(Vehiculo vehiculo){
        return(Vehiculo) vehiculoRepository.save(vehiculo);
    }
    public Optional<Vehiculo> eliminarVehiculo(Long id){
        Optional<Vehiculo> vehiculoEliminado = this.vehiculoRepository.findById(id);
        if(vehiculoEliminado.isPresent()){
            Vehiculo vehiculo = vehiculoEliminado.get();
            List<Factura> facturas = facturaRepository.findByTrabajo_VehiculoTrabajado(vehiculo);
            if(!facturas.isEmpty()){
                // throw new VehiculoNotFoundException("No se ha podido eliminar vehiculo, ya que TIENE FACTURAS ASOCIADAS.");
            }
            this.vehiculoRepository.deleteById(id);
        }
        return vehiculoEliminado;
    }


}
