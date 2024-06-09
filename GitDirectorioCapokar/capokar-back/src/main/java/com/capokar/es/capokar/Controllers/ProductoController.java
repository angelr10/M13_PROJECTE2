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

import com.capokar.es.capokar.Model.Producto;
import com.capokar.es.capokar.Services.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping("/mostrarProductos")
    public ArrayList<Producto> getProductos(){
        return this.productoService.getProductos();
    }

    @PostMapping("/guardarProducto")
    public Producto guardarProducto(@RequestBody Producto producto){
        return this.productoService.guardarProducto(producto);
    }

    @DeleteMapping("eliminarProductoID/{id}")
    public Optional<Producto> eliminarProductoPorId(@PathVariable Long id){
        return this.productoService.eliminarProducto(id);
    }
    
}
