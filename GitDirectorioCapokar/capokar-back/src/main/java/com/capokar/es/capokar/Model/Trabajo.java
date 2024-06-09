package com.capokar.es.capokar.Model;

import java.time.LocalTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="trabajo")
public class Trabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_trabajo;

    @ManyToMany
    @JoinTable(
        name = "trabajo_empleado",
        joinColumns = @JoinColumn(name = "id_trabajo"),
        inverseJoinColumns = @JoinColumn(name = "id_empleado")
    )
    private Set<Empleado> trabajadoresACargo;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo",nullable =false)
    private Vehiculo vehiculoTrabajado;

    @Column
    private float costeTotalManoObra;

    @Column
    private String estado;

    @Column
    private LocalTime tiempo;

    public Long getId_trabajo() {
        return id_trabajo;
    }

    public void setId_trabajo(Long id_trabajo) {
        this.id_trabajo = id_trabajo;
    }

    public Set<Empleado> getTrabajadoresACargo() {
        return trabajadoresACargo;
    }

    public void setTrabajadoresACargo(Set<Empleado> trabajadoresACargo) {
        this.trabajadoresACargo = trabajadoresACargo;
    }

    public Vehiculo getVehiculoTrabajado() {
        return vehiculoTrabajado;
    }

    public void setVehiculoTrabajado(Vehiculo vehiculoTrabajado) {
        this.vehiculoTrabajado = vehiculoTrabajado;
    }

    public float getCosteTotalManoObra() {
        return costeTotalManoObra;
    }

    public void setCosteTotalManoObra(float costeTotalManoObra) {
        this.costeTotalManoObra = costeTotalManoObra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalTime getTiempo() {
        return tiempo;
    }

    public void setTiempo(LocalTime tiempo) {
        this.tiempo = tiempo;
    }

    
}


