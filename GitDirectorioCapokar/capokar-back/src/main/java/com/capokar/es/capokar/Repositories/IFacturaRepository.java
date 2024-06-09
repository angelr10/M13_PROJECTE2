package com.capokar.es.capokar.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capokar.es.capokar.Model.Factura;
import com.capokar.es.capokar.Model.Trabajo;
import com.capokar.es.capokar.Model.Vehiculo;

@Repository
public interface IFacturaRepository extends JpaRepository<Factura,Long>{
    List<Factura> findByTrabajo_VehiculoTrabajado(Vehiculo vehiculo);
    List<Factura> findByTrabajo(Trabajo trabajo);
}
