package com.capokar.es.capokar.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capokar.es.capokar.Model.Empleado;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long>{
    
}