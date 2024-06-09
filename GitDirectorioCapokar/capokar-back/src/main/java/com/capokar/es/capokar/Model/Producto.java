package com.capokar.es.capokar.Model;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    @ManyToMany
    @JoinTable(
        name = "producto_subcategoria",
        joinColumns = @JoinColumn(name = "id_producto"),
        inverseJoinColumns = @JoinColumn(name = "id_subcategoria")
    )
    private Set<Subcategoria> subcategoria;

    @Column
    private String nombre;

    @Column
    private String marca;

    @Column
    private String descripcion;

    @Column
    private String cantidadDisponible;

    @Column
    private String tipo_cantidad;

    @Column
    private float precio_unitario;
    
    
    public Long getId_producto() {
        return id_producto;
    }

    public Set<Subcategoria> getSubcategoria() {
        return subcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCantidadDisponible() {
        return cantidadDisponible;
    }

    public String getTipo_cantidad() {
        return tipo_cantidad;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public void setSubcategoria(Set<Subcategoria> subcategoria) {
        this.subcategoria = subcategoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidadDisponible(String cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public void setTipo_cantidad(String tipo_cantidad) {
        this.tipo_cantidad = tipo_cantidad;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    
    
    
}