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
import org.una.agencia.dto.CiudadDTO;
import org.una.agencia.services.ICiudadService;

/**
 *
 * @author Luis
 */

@RestController
@RequestMapping("/ciudades") 
@Api(tags = {"Ciudades"})
public class CiudadController {
    
    @Autowired
    private ICiudadService ciudadService;
    final String MENSAJE_VERIFICAR_INFORMACION = "Debe verifiar el formato y la información de su solicitud con el formato esperado";
    
    @GetMapping("/") 
    @ApiOperation(value = "Obtiene una lista de todas las ciudades", response = CiudadDTO.class, responseContainer = "List", tags = "Ciudades")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity(ciudadService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}") 
    @ApiOperation(value = "Obtiene una ciudad por su identificador unico", response = CiudadDTO.class, tags = "Ciudades")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity<>(ciudadService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea una ciudad", response = HttpStatus.class, tags = "Ciudades")
    @PostMapping("/") 
    @ResponseBody
    public ResponseEntity<?> create(@Valid @RequestBody CiudadDTO ciudadDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                return new ResponseEntity(ciudadService.create(ciudadDTO), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
        return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }
}
