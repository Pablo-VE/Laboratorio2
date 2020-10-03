/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.services;

import java.util.List;
import java.util.Optional;
import org.una.agencia.dto.TarjetaCreditoDTO;

/**
 *
 * @author Luis
 */
public interface ITarjetaCreditoService {
    
    public Optional<List<TarjetaCreditoDTO>> findAll();

    public Optional<TarjetaCreditoDTO> findById(Long id);
    
    public TarjetaCreditoDTO create(TarjetaCreditoDTO tarjetaCredito);
    
}
