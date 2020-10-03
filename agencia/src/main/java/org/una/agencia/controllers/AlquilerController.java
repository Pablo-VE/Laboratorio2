/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.controllers;

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
import org.una.agencia.dto.AlquilerDTO;
import org.una.agencia.services.IAlquilerService;

/**
 *
 * @author Luis
 */

@RestController
@RequestMapping("/alquileres") 
public class AlquilerController {
    
    @Autowired
    private IAlquilerService alquilerService;

    final String MENSAJE_VERIFICAR_INFORMACION = "Debe verifiar el formato y la información de su solicitud con el formato esperado";

    @GetMapping("/") 
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity(alquilerService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}") 
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity<>(alquilerService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/") 
    @ResponseBody
    public ResponseEntity<?> create(@Valid @RequestBody AlquilerDTO alquilerDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                return new ResponseEntity(alquilerService.create(alquilerDTO), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
        return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/titularAndMatricula/{nombre}/{matricula}") 
    public @ResponseBody
    ResponseEntity<?> findByTitularTarjetaAndMatriculaVehiculo(@PathVariable(value = "nombre") String nombre, @PathVariable(value = "matricula") String matricula) {
        try {
            return new ResponseEntity(alquilerService.findByTitularTarjetaAndMatriculaVehiculo(nombre, matricula), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/cedulaAndMatricula/{cedula}/{matricula}") 
    public @ResponseBody
    ResponseEntity<?> findByCedulaClienteAndMatriculaVehiculo(@PathVariable(value = "cedula") String cedula, @PathVariable(value = "matricula") String matricula) {
        try {
            return new ResponseEntity(alquilerService.findByCedulaClienteAndMatriculaVehiculo(cedula, matricula), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
   @GetMapping("/precioAndNombre/{precio}/{nombre}") 
    public @ResponseBody
    ResponseEntity<?> findByPrecioAndTipoSeguro(@PathVariable(value = "precio") double precio, @PathVariable(value = "nombre") String nombre) {
        try {
            return new ResponseEntity(alquilerService.findByPrecioAndTipoSeguro(precio, nombre), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
