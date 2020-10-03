/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.services;

import java.util.List;
import java.util.Optional;
import org.una.agencia.dto.VehiculoDTO;


/**
 *
 * @author Luis
 */
public interface IVehiculoService {
    
    public Optional<List<VehiculoDTO>> findAll();

    public Optional<VehiculoDTO> findById(Long id);
    
}
