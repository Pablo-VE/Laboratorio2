/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.services;

import java.util.List;
import java.util.Optional;
import org.una.agencia.dto.CiudadDTO;
 

/**
 *
 * @author Luis
 */
public interface ICiudadService {
    
    public Optional<List<CiudadDTO>> findAll();

    public Optional<CiudadDTO> findById(Long id);
    
   public CiudadDTO create(CiudadDTO ciudad);
    
}
