/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.una.agencia.dto.TamanoVehiculoDTO;
import org.una.agencia.services.ITamanoVehiculoService;
 
/**
 *
 * @author Luis
 */

@RestController
@RequestMapping("/tamanosVehiculo") 
@Api(tags = {"Tamanos_Vehiculos"})
public class TamanoVehiculoController {
    
    @Autowired
    private ITamanoVehiculoService tamanoVehiculoService;
    final String MENSAJE_VERIFICAR_INFORMACION = "Debe verifiar el formato y la información de su solicitud con el formato esperado";

    @GetMapping("/") 
    public @ResponseBody
    @ApiOperation(value = "Obtiene una lista de todos los tamanos de vehiculos", response = TamanoVehiculoDTO.class, responseContainer = "List", tags = "Tamanos_Vehiculos")
    ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity(tamanoVehiculoService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}") 
    @ApiOperation(value = "Obtiene una tamano de vehiculo por su id", response = TamanoVehiculoDTO.class, responseContainer = "List", tags = "Tamanos_Vehiculos")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity<>(tamanoVehiculoService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
     
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea un tamano de vehiculo", response = HttpStatus.class, tags = "Tamanos_Vehiculos")
    @PostMapping("/") 
    @ResponseBody
    public ResponseEntity<?> create(@Valid @RequestBody TamanoVehiculoDTO tamanoVehiculoDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                return new ResponseEntity(tamanoVehiculoService.create(tamanoVehiculoDTO), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
        return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }
}
