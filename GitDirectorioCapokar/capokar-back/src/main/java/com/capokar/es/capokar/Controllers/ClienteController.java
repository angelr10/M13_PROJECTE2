package com.capokar.es.capokar.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capokar.es.capokar.Model.Cliente;
import com.capokar.es.capokar.Services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/mostrarClientes")
    public ArrayList<Cliente> muestraClientes(){
        return this.clienteService.getClientes();
    }

    @PostMapping("/guardarCliente")
    public Cliente guardarCliente(@RequestBody Cliente cliente){
        return this.clienteService.guardarCliente(cliente);
    }

    @DeleteMapping("/eliminarClienteID/{id}")
    public Optional<Cliente> eliminarClientePorId(@PathVariable Long id){
        Optional<Cliente> eliminado = this.clienteService.eliminarCliente(id);
        return eliminado;
    }

    @PutMapping("/actualizarClienteID/{id}")
    public Optional<Cliente> actualizarClientePorID(@PathVariable Long id, @RequestBody Cliente cliente){
        return clienteService.actualizarCliente(id, cliente);
    }
}
