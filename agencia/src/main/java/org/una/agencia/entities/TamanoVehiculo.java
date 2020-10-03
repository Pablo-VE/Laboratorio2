/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "lab2_tamanos_vehiculos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TamanoVehiculo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private double altura;
    
    @Column
    private double anchura;
    
    @Column
    private double longitud;
    
    @OneToOne(mappedBy = "tamanoVehiculo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private GrupoVehiculo grupoVehiculo;
    
    
}
