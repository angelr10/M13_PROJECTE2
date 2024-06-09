package com.capokar.es.capokar.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capokar.es.capokar.Model.Producto;

import com.capokar.es.capokar.Repositories.IProductoRepository;

@Service
public class ProductoService {
    @Autowired
    IProductoRepository productoRepository;
    
    public ArrayList<Producto> getProductos(){
        return(ArrayList<Producto>) productoRepository.findAll();
    }

    public Producto guardarProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public Optional<Producto> eliminarProducto(Long id){
        Optional<Producto> productoEliminado = productoRepository.findById(id);
        if(productoEliminado!=null){
            productoRepository.deleteById(id);
        }
        return productoEliminado;
    }

}
