package com.capokar.es.capokar.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capokar.es.capokar.Model.Cliente;
import com.capokar.es.capokar.Repositories.IClienteRepository;
import com.capokar.es.capokar.seguridad.JwtUtil;

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

    public boolean comprobarExisteUsuario(String nombre){
        Optional<Cliente> clienteEncontradoNombre = clienteRepository.findByNombre(nombre);
        if(clienteEncontradoNombre.isPresent()){
            return true;
        }else{
            return false;
        }
        
    }
    public String intentoIniciarSesion(String nombre, String contra){
        Optional<Cliente> clienteEncontradoNombre = clienteRepository.findByNombre(nombre);
        if(clienteEncontradoNombre!=null){
            Cliente clienteExistente = clienteEncontradoNombre.get();
            if(clienteExistente.getContraseña().equals(contra)){
                return JwtUtil.generateToken(clienteExistente);
            }else{
                return null;
            }
        }
        return null;
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

    public Optional<Cliente> buscarClienteID(Long idClienteBuscar){
        Optional<Cliente> clienteBuscado = clienteRepository.findById(idClienteBuscar);
        if(clienteBuscado.isPresent()){
            return clienteBuscado;
        }
        return null;
    }
}
