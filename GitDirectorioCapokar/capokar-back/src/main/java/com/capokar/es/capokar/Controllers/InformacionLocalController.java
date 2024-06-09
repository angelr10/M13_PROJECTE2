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

import com.capokar.es.capokar.Model.InformacionLocal;
import com.capokar.es.capokar.Services.InformacionLocalService;

@RestController
@RequestMapping("/informacionlocal")
public class InformacionLocalController {
    @Autowired
    public InformacionLocalService informacionLocalService;

    @GetMapping("/mostrarInformacionLocal")
    public ArrayList<InformacionLocal> getInformacionLocal(){
        return this.informacionLocalService.getInformacionLocal();
    }

    @PostMapping("/guardarInformacionLocal")
    public InformacionLocal guardarInformacionLocal(@RequestBody InformacionLocal informacionLocal){
        return this.informacionLocalService.guardarInformacionLocal(informacionLocal);
    }

    @DeleteMapping("/eliminaInformacionLocalID/{id}")
    public Optional<InformacionLocal> eliminarInformacionLocalPorId(@RequestParam Long id){
        Optional<InformacionLocal> eliminado = this.informacionLocalService.eliminarInformacionLocal(id);
        return eliminado;
    }
}
