package com.capokar.es.capokar.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capokar.es.capokar.Services.FacturaService;
import com.capokar.es.capokar.Model.Factura;

@RestController
@RequestMapping("/facturas")
public class FacturaController {
    @Autowired
    public FacturaService facturaService;

    @GetMapping("/mostrarFacturas") 
    public ArrayList<Factura> mostrarFacturas(){
        return facturaService.getFacturas();
    }

    @PostMapping("/guardarFactura")
    public Factura guardarFactura(@RequestBody Factura factura){
        return facturaService.guardarFactura(factura);
    }

    @DeleteMapping("/eliminarFactura/{id}")
    public Optional<Factura> eliminarFacturaPorID(@RequestParam Long id){
        Optional<Factura> eliminado = this.facturaService.eliminarFactura(id);
        return eliminado;
    }
}
