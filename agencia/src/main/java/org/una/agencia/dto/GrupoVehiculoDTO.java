/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.dto;

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
public class GrupoVehiculoDTO {
    private Long id;
    private String nombre;
    private TamanoVehiculoDTO tamanoVehiculo;
    private String tipo;
    private boolean estado;
}
