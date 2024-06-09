package com.capokar.es.capokar.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Date;



@Entity
@Table(name="vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vehiculo;

    @ManyToOne
    @JoinColumn(name = "id_cliente",nullable =false)
    private Cliente cliente;

    @Column
    private String marca;

    @Column
    private String modelo;

    @Column
    private Date anyo_fabricacion;

    @Column
    private String matricula;

    @Column
    private int kilometros;

    public Long getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(Long id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getAño_fabricacion() {
        return anyo_fabricacion;
    }

    public void setAño_fabricacion(Date año_fabricacion) {
        this.anyo_fabricacion = año_fabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public Date getAnyo_fabricacion() {
        return anyo_fabricacion;
    }

    public void setAnyo_fabricacion(Date anyo_fabricacion) {
        this.anyo_fabricacion = anyo_fabricacion;
    }
    
    
}