/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "lab2_vehiculos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vehiculo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 10, nullable = false, unique = true)
    private String matricula;
    
    @Column(length = 10)
    private String marca;
    
    @Column(length = 15)
    private String modelo;
    
    @Column(name="numero_puertas")
    private int numeroPuertas;
    
    @Column(name="numero_asientos")
    private int numeroAsientos;
    
    @Column(name="capacidad_maletero")
    private float capacidadMaletero;
    
    @Column(name="edad_minima_alquiler")
    private int edadMinimaAlquiler;
    
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
    
    @ManyToOne 
    @JoinColumn(name="lab2_oficinas_id")
    private Oficina oficina;
    
    @ManyToOne 
    @JoinColumn(name="lab2_grupos_id")
    private GrupoVehiculo grupo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculo") 
    private List<Alquiler> alquileres= new ArrayList<>();
    
}
