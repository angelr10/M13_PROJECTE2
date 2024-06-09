package com.capokar.es.capokar.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="recambio")
public class Recambio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_recambio;

    @ManyToOne
    @JoinColumn(name="id_producto",nullable=false)
    private Producto producto;

    @Column
    private int cantidadUsada;

    @Column
    private float precioUnidad;

    @Column
    private int descuento;

    @Column
    private float preciTotalRecambio;

    

    public Long getId_recambio() {
        return id_recambio;
    }

    public void setId_recambio(Long id_recambio) {
        this.id_recambio = id_recambio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidadUsada() {
        return cantidadUsada;
    }

    public void setCantidadUsada(int cantidadUsada) {
        this.cantidadUsada = cantidadUsada;
    }

    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public float getPreciTotalRecambio() {
        return preciTotalRecambio;
    }

    public void setPreciTotalRecambio(float preciTotalRecambio) {
        this.preciTotalRecambio = preciTotalRecambio;
    }
    
    
}
