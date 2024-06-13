package com.capokar.es.capokar.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capokar.es.capokar.Model.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long>{
    Optional<Cliente> findByNombre(String nombre);
}
