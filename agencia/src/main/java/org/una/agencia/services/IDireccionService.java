/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.services;

import java.util.List;
import java.util.Optional;
import org.una.agencia.dto.DireccionDTO;

/**
 *
 * @author Luis
 */
public interface IDireccionService {
    
    public Optional<List<DireccionDTO>> findAll();

    public Optional<DireccionDTO> findById(Long id); 
    
    public DireccionDTO create(DireccionDTO direccion);
}
