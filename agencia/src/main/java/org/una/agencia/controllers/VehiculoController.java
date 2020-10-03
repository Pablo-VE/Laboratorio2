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
import org.una.agencia.dto.VehiculoDTO;
import org.una.agencia.services.IVehiculoService;
 

/**
 *
 * @author Luis
 */

@RestController
@RequestMapping("/vehiculos") 
@Api(tags = {"Vehiculos"})
public class VehiculoController {
    
    @Autowired
    private IVehiculoService vehiculoService;
    final String MENSAJE_VERIFICAR_INFORMACION = "Debe verifiar el formato y la información de su solicitud con el formato esperado";

    @GetMapping("/") 
    @ApiOperation(value = "Obtiene una lista de todos los vehiculos", response = VehiculoDTO.class, responseContainer = "List", tags = "Vehiculos")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity(vehiculoService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}") 
    @ApiOperation(value = "Obtiene un vehiculo por su identificador unico", response = VehiculoDTO.class, tags = "Vehiculos")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity<>(vehiculoService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea un vehiculo", response = HttpStatus.class, tags = "Vehiculos")
    @PostMapping("/") 
    @ResponseBody
    public ResponseEntity<?> create(@Valid @RequestBody VehiculoDTO vehiculoDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                return new ResponseEntity(vehiculoService.create(vehiculoDTO), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
        return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/grupoAndEstado/{nomGrupo}/{estado}") 
    @ApiOperation(value = "Obtiene una lista de vehiculos por grupo y estado", response = VehiculoDTO.class, responseContainer = "List", tags = "Vehiculos")
    public @ResponseBody
    ResponseEntity<?> findByNombreGrupoAndEstado(@PathVariable(value = "nomGrupo") String nomGrupo, @PathVariable(value = "estado") boolean estado) {
        try {
            return new ResponseEntity(vehiculoService.findByNombreGrupoAndEstado(nomGrupo, estado), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
