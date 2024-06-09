package com.capokar.es.capokar.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capokar.es.capokar.Model.Recambio;

import com.capokar.es.capokar.Services.RecambioService;

@RestController
@RequestMapping("/recambios")
public class RecambioController {
    @Autowired
    RecambioService recambioService;

    @GetMapping("/mostrarRecambios")
    public ArrayList<Recambio> getRecambios(){
        return this.recambioService.getRecambios();
    }

    @PostMapping("/guardarRecambio")
    public Recambio guardarRecambio(@RequestBody Recambio recambio){
        return this.recambioService.guardarRecambio(recambio);
    }
}
