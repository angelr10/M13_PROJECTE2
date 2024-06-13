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

    @GetMapping("/buscarClienteID/{id_cliente}")
    public Optional<Cliente> buscarClienteID(@PathVariable Long id_cliente){
        return this.clienteService.buscarClienteID(id_cliente);
    }

    @PostMapping("/guardarCliente")
    public Cliente guardarCliente(@RequestBody Cliente cliente){
        return this.clienteService.guardarCliente(cliente);
    }

    @GetMapping("/comprobarExiste/{NombreUsuario}")
    public boolean comprobarExistenciaCliente(@PathVariable("NombreUsuario") String NombreUsuario){
        return this.clienteService.comprobarExisteUsuario(NombreUsuario);
    }

    @GetMapping("/iniciarSesionCliente/{NombreUsuario}/{contraseña}")
    public String probarUsuarioYContraseña(@PathVariable String NombreUsuario,@PathVariable String contraseña){
        String token = this.clienteService.intentoIniciarSesion(NombreUsuario,contraseña);
        if(token!=null){
            return token;
        }
        return "Error al autorizar token";
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
