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
@Table(name="factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_factura;

    @ManyToOne
    @JoinColumn(name = "id_cliente_en_factura")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_trabajo_en_factura")
    private Trabajo trabajo;

    @ManyToOne
    @JoinColumn(name = "id_local")
    private InformacionLocal informacionLocal;

    //ARRAYLISTRECAMBIOS
    @ManyToOne
    @JoinColumn(name = "id_recambio")
    private Recambio recambios;

    @Column
    private Date fecha_factura;

    @Column
    private String nifempresa;

    @Column
    private String nombre_representante;

    @Column
    private String apellido_representante;

    @Column
    private String matriculaVehiculoFactura; //Obtener matricula de trabajo.vehiculoTrabajado

    @Column 
    private String modeloVehiculoFactura; //Obtener modelo de trabajo.vehiculoTrabajado

    @Column
    private int kilometros_actualesvehiculoFactura; //Obtener kilometros_actuales de trabajo.vehiculoTrabajado

    //ManoDeObra
    @Column
    private float manoDeObraFactura;

    //precioTotalBrutoTrabajo
    @Column
    private float precioTotalBrutoFactura;

    //iva
    @Column
    private float iva;

    //precioTotal
    @Column
    private float precioTotalFactura;
    
    public Long getId_factura() {
        return id_factura;
    }
    public void setId_factura(Long id_factura) {
        this.id_factura = id_factura;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public InformacionLocal getInformacionLocal() {
        return informacionLocal;
    }
    public void setInformacionLocal(InformacionLocal informacionLocal) {
        this.informacionLocal = informacionLocal;
    }
    public Date getFecha_factura() {
        return fecha_factura;
    }
    public void setFecha_factura(Date fecha_factura) {
        this.fecha_factura = fecha_factura;
    }
    public String getNifempresa() {
        return nifempresa;
    }
    public void setNifempresa(String nifempresa) {
        this.nifempresa = nifempresa;
    }
    public String getNombre_representante() {
        return nombre_representante;
    }
    public void setNombre_representante(String nombre_representante) {
        this.nombre_representante = nombre_representante;
    }
    public String getApellido_representante() {
        return apellido_representante;
    }
    public void setApellido_representante(String apellido_representante) {
        this.apellido_representante = apellido_representante;
    }
    public Trabajo getTrabajo() {
        return trabajo;
    }
    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }
    public String getMatriculaVehiculoFactura() {
        return matriculaVehiculoFactura;
    }
    public void setMatriculaVehiculoFactura(String matriculaVehiculoFactura) {
        this.matriculaVehiculoFactura = matriculaVehiculoFactura;
    }
    public String getModeloVehiculoFactura() {
        return modeloVehiculoFactura;
    }
    public void setModeloVehiculoFactura(String modeloVehiculoFactura) {
        this.modeloVehiculoFactura = modeloVehiculoFactura;
    }
    public int getKilometros_actualesvehiculoFactura() {
        return kilometros_actualesvehiculoFactura;
    }
    public void setKilometros_actualesvehiculoFactura(int kilometros_actualesvehiculoFactura) {
        this.kilometros_actualesvehiculoFactura = kilometros_actualesvehiculoFactura;
    }
    public float getManoDeObraFactura() {
        return manoDeObraFactura;
    }
    public void setManoDeObraFactura(float manoDeObraFactura) {
        this.manoDeObraFactura = manoDeObraFactura;
    }
    public float getPrecioTotalBrutoFactura() {
        return precioTotalBrutoFactura;
    }
    public void setPrecioTotalBrutoFactura(float precioTotalBrutoFactura) {
        this.precioTotalBrutoFactura = precioTotalBrutoFactura;
    }
    public float getIva() {
        return iva;
    }
    public void setIva(float iva) {
        this.iva = iva;
    }
    public float getPrecioTotalFactura() {
        return precioTotalFactura;
    }
    public void setPrecioTotalFactura(float precioTotalFactura) {
        this.precioTotalFactura = precioTotalFactura;
    }
    public Recambio getRecambios() {
        return recambios;
    }
    public void setRecambios(Recambio recambios) {
        this.recambios = recambios;
    }
    
    
    
}
