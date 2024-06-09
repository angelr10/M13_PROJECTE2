package com.capokar.es.capokar.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capokar.es.capokar.Model.Factura;
import com.capokar.es.capokar.Model.InformacionLocal;
import com.capokar.es.capokar.Model.Trabajo;
import com.capokar.es.capokar.Model.Vehiculo;
import com.capokar.es.capokar.Repositories.IFacturaRepository;
import com.capokar.es.capokar.Repositories.IRecambioRepository;
import com.capokar.es.capokar.Repositories.ITrabajoRepository;
import com.capokar.es.capokar.Repositories.IinformacionLocalRepository;

@Service
public class FacturaService {
    @Autowired
    IFacturaRepository facturaRepository;

    @Autowired
    IinformacionLocalRepository informacionLocalRepository;

    @Autowired
    ITrabajoRepository trabajoRepository;

    @Autowired
    IRecambioRepository recambioRepository;

    public ArrayList<Factura> getFacturas(){
        return(ArrayList<Factura>) this.facturaRepository.findAll();
    }

    public Factura guardarFactura(Factura factura){
        InformacionLocal infoLocal = informacionLocalRepository.findById(factura.getInformacionLocal().getId_local()).orElse(null);
        Trabajo trabajo = trabajoRepository.findById(factura.getTrabajo().getId_trabajo()).orElse(null);

        if(infoLocal != null){
            factura.setNifempresa(infoLocal.getNif());
            factura.setNombre_representante(infoLocal.getNombre_representante());
            factura.setApellido_representante(infoLocal.getApellido_representante());
        }
        if(trabajo != null){
            factura.setManoDeObraFactura(trabajo.getCosteTotalManoObra());
            factura.setPrecioTotalBrutoFactura(0);//Calculo del precio de cada uno de los recambios
            factura.setIva(21);
            factura.setPrecioTotalFactura(0);//Calculo precioTotalBruto aplicando iva
            Vehiculo vehiculo = trabajo.getVehiculoTrabajado();
            if(vehiculo != null){
                factura.setMatriculaVehiculoFactura(vehiculo.getMatricula());
                factura.setModeloVehiculoFactura(vehiculo.getModelo());
                factura.setKilometros_actualesvehiculoFactura(vehiculo.getKilometros());
            }
        }
        return(Factura) facturaRepository.save(factura);
    }
    public Optional<Factura> eliminarFactura(Long id){
        Optional<Factura> facturaEliminado = this.facturaRepository.findById(id);
        if(facturaEliminado.isPresent()){
            facturaRepository.deleteById(id);
        }
        return facturaEliminado;
    }
}
