/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.services;

import java.util.List;
import java.util.Optional;
import org.una.agencia.dto.AlquilerDTO;

/**
 *
 * @author Luis
 */
public interface IAlquilerService {
   
    public Optional<List<AlquilerDTO>> findAll();

    public Optional<AlquilerDTO> findById(Long id);
    
    public AlquilerDTO create(AlquilerDTO alqiler);
}
