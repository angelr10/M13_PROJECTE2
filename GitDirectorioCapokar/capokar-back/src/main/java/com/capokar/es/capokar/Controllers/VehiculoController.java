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
import com.capokar.es.capokar.Model.Vehiculo;
import com.capokar.es.capokar.Services.VehiculoService;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired
    public VehiculoService vehiculoService;

    @GetMapping("/mostrarVehiculos")
    public ArrayList<Vehiculo> getVehiculos(){
        return this.vehiculoService.getVehiculos();
    }

    @PostMapping("/guardarVehiculo")
    public Vehiculo guardarVehiculo(@RequestBody Vehiculo vehiculo){
        return this.vehiculoService.guardarVehiculo(vehiculo);
    }

    @DeleteMapping("/eliminarVehiculoID/{id}")
    public Optional<Vehiculo> eliminarVehiculoPorId(@PathVariable Long id){
        Optional<Vehiculo> eliminado = this.vehiculoService.eliminarVehiculo(id);
        return eliminado;
    }
}
