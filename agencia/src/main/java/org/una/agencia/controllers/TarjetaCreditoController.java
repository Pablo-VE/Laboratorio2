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
import org.una.agencia.dto.TarjetaCreditoDTO;
import org.una.agencia.services.ITarjetaCreditoService;
 

/**
 *
 * @author Luis
 */

@RestController
@RequestMapping("/tarjetasCredito") 
@Api(tags = {"Tarjetas_Credito"})
public class TarjetaCreditoController {
    
    @Autowired
    private ITarjetaCreditoService tarjetaCreditoService;

    final String MENSAJE_VERIFICAR_INFORMACION = "Debe verifiar el formato y la información de su solicitud con el formato esperado";

    @GetMapping("/")  
    @ApiOperation(value = "Obtiene una lista de todas las oficinas", response = TarjetaCreditoDTO.class, responseContainer = "List", tags = "Tarjetas_Credito")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity(tarjetaCreditoService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}") 
    @ApiOperation(value = "Obtiene una tarjeta de credito por su id", response = TarjetaCreditoDTO.class, tags = "Tarjetas_Credito")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity<>(tarjetaCreditoService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea una tarjeta de credito", response = HttpStatus.class, tags = "Tarjetas_Credito")
    @PostMapping("/") 
    @ResponseBody
    public ResponseEntity<?> create(@Valid @RequestBody TarjetaCreditoDTO tarjetaCreditoDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                return new ResponseEntity(tarjetaCreditoService.create(tarjetaCreditoDTO), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
        return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }
}
