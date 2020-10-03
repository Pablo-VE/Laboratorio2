/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.services;

import java.util.List;
import java.util.Optional;
import org.una.agencia.dto.TipoSeguroDTO;

/**
 *
 * @author Luis
 */
public interface ITipoSeguroService {
    
    public Optional<List<TipoSeguroDTO>> findAll();

    public Optional<TipoSeguroDTO> findById(Long id);
    
    public TipoSeguroDTO create(TipoSeguroDTO tipoSeguro);
    
}
