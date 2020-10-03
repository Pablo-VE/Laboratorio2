/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.services;

import java.util.List;
import java.util.Optional;
import org.una.agencia.dto.GrupoVehiculoDTO;

/**
 *
 * @author Luis
 */
public interface IGrupoVehiculoService {
    
    public Optional<List<GrupoVehiculoDTO>> findAll();

    public Optional<GrupoVehiculoDTO> findById(Long id);
    
    public GrupoVehiculoDTO create(GrupoVehiculoDTO grupoVehiculo);
    
}
