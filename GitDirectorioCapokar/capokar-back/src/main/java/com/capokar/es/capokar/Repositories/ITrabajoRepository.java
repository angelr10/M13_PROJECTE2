package com.capokar.es.capokar.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capokar.es.capokar.Model.Trabajo;

@Repository
public interface ITrabajoRepository extends JpaRepository<Trabajo,Long>{

}
