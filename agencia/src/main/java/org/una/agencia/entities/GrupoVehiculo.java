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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Pablo-VE
 */
@Entity
@Table(name = "lab2_grupos_vehiculos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GrupoVehiculo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 1)
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo") 
    private List<Vehiculo> vehiculos= new ArrayList<>();
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tamano_vehiculo", referencedColumnName = "id")
    private TamanoVehiculo tamanoVehiculo;
    
    @Column(length = 15)
    private String tipo;
    
    @Column
    private boolean estado;
    
    @PrePersist
    public void prePersist() {
        estado=true;
    }
    
}
