/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.dto;

import javax.json.bind.annotation.JsonbDateFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Jeffry
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class VehiculoDTO {
    private Long id;
    private String matricula;
    private String marca;
    private String modelo;
    private int numeroPuertas;
    private int numeroAsientos;
    private float capacidadMaletero;
    private int edadMinimaAlquiler;
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private java.util.Date fechaRegistro;
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private java.util.Date fechaModificacion;
    private boolean estado;
    private OficinaDTO oficina;
    private GrupoVehiculoDTO grupo;
}
