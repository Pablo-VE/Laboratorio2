/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Pablo-VE
 */
@Entity
@Table(name = "lab2_alquileres")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Alquiler implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private int duracion;
    
    @Column
    private double precio;
    
    @ManyToOne 
    @JoinColumn(name="vehiculo")
    private Vehiculo vehiculo;
    
    @ManyToOne 
    @JoinColumn(name="tipo_seguro")
    private TipoSeguro tipoSeguro;
    


    @ManyToOne 
    @JoinColumn(name="tarjeta_credito")
    private TarjetaCredito tarjetaCredito;
 
    
    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    @Column
    private boolean estado;
    
    @PrePersist
    public void prePersist() {
        estado=true;
        fechaRegistro = new Date();
        fechaModificacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = new Date();
    }

   
    
}
