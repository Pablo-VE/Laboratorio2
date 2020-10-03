/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.agencia.dto.VehiculoDTO;
import org.una.agencia.repositories.IVehiculoRepository;
import org.una.agencia.utils.ServiceConvertionHelper;


/**
 *
 * @author Luis
 */
@Service
public class VehiculoServiceImplementation implements IVehiculoService{

    
    @Autowired
    private IVehiculoRepository vehiculoRepository;
        
    @Override
    public Optional<List<VehiculoDTO>> findAll() {
        return ServiceConvertionHelper.findList(vehiculoRepository.findAll(), VehiculoDTO.class);
    }

    @Override
    public Optional<VehiculoDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(vehiculoRepository.findById(id), VehiculoDTO.class);
    }
    
}
