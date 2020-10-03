/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.dto;
import java.util.Date;
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
public class AlquilerDTO {

    private Long id;
    private int duracion;
    private double precio;
    private VehiculoDTO vehiculo;
    private TipoSeguroDTO tipoSeguro;
    private TarjetaCreditoDTO tarjetaCredito;
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private java.util.Date fechaRegistro;
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private java.util.Date fechaModificacion;
    private boolean estado;
}
