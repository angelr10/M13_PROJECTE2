package com.capokar.es.capokar.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capokar.es.capokar.Model.Cliente;
import com.capokar.es.capokar.Repositories.IClienteRepository;

@Service
public class ClienteService{
    @Autowired
    IClienteRepository clienteRepository;

    public ArrayList<Cliente> getClientes(){
        return (ArrayList<Cliente>) clienteRepository.findAll();
    }

    public Cliente guardarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> eliminarCliente(Long id){
        Optional<Cliente> clienteEliminado = clienteRepository.findById(id);
        if(clienteEliminado.isPresent()){
            clienteRepository.deleteById(id);
        }
        return clienteEliminado;
    }

    public Optional<Cliente> actualizarCliente(Long id,Cliente cliente){
        Optional<Cliente> clienteAntesDeActualizar = clienteRepository.findById(id);
        if (clienteAntesDeActualizar.isPresent()){
            Cliente clienteExistente = clienteAntesDeActualizar.get();
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setApellido(cliente.getApellido());
            clienteExistente.setDireccion(cliente.getDireccion());
            clienteExistente.setPoblacion(cliente.getPoblacion());
            clienteExistente.setTelefono(cliente.getTelefono());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setDNI(cliente.getDNI());
            clienteExistente.setFecha_creacion(cliente.getFecha_creacion());
            clienteExistente.setContraseña(cliente.getContraseña());
            clienteRepository.save(clienteExistente);
            return Optional.of(clienteExistente);
        }
        return Optional.empty();
    }
}
