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
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
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
 * @author Jeffry
 */
@Entity
@Table(name = "lab2_tarjetas_credito")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TarjetaCredito implements Serializable{
    
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    
    @Column(name = "nombre_titular", length = 50)
    private String nombreTitular;
    
    @Column(name = "numero_tarjeta", length = 15)
    private String numeroTarjeta;
    
    @Column(name = "fecha_vencimiento")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    
    @Column
    private boolean estado;
    
    @PrePersist
    public void prePersist() {
        estado=true;
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarjetaCredito") 
    private List<Alquiler> alquileres= new ArrayList<>();
    
    
    @ManyToOne 
    @JoinColumn(name="cliente")
    @MapsId
    private Cliente cliente;
    
    
    
}
