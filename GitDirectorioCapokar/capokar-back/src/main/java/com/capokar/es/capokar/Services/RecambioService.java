package com.capokar.es.capokar.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capokar.es.capokar.Model.Producto;
import com.capokar.es.capokar.Model.Recambio;
import com.capokar.es.capokar.Repositories.IProductoRepository;
import com.capokar.es.capokar.Repositories.IRecambioRepository;

@Service
public class RecambioService {
    @Autowired
    IRecambioRepository recambioRepository;

    @Autowired
    IProductoRepository productoRepository;


    public ArrayList<Recambio> getRecambios(){
        return(ArrayList<Recambio>) this.recambioRepository.findAll();
    }

    public Recambio guardarRecambio(Recambio recambio){
        Producto productoGuardaro = productoRepository.findById(recambio.getProducto().getId_producto()).orElse(null);
        if (productoGuardaro != null){
            recambio.setPrecioUnidad(productoGuardaro.getPrecio_unitario());
        }
        return(Recambio) this.recambioRepository.save(recambio);
    }
}
