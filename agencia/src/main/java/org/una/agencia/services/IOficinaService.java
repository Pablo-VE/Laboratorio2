/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.services;

import java.util.List;
import java.util.Optional;
import org.una.agencia.dto.OficinaDTO;

/**
 *
 * @author Luis
 */
public interface IOficinaService {
    
    public Optional<List<OficinaDTO>> findAll();

    public Optional<OficinaDTO> findById(Long id);
    
    public OficinaDTO create(OficinaDTO oficina);
}
