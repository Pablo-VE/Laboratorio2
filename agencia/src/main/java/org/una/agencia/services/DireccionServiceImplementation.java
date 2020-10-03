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
import org.una.agencia.dto.DireccionDTO;
import org.una.agencia.entities.Direccion;
import org.una.agencia.repositories.IDireccionRepository;
import org.una.agencia.utils.MapperUtils;
import org.una.agencia.utils.ServiceConvertionHelper;

/**
 *
 * @author Luis
 */
@Service
public class DireccionServiceImplementation implements IDireccionService{
    
    @Autowired
    private IDireccionRepository direccionRepository;
        
    
    @Override
    public Optional<List<DireccionDTO>> findAll() {
        return ServiceConvertionHelper.findList(direccionRepository.findAll(), DireccionDTO.class);
    }

    @Override
    public Optional<DireccionDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(direccionRepository.findById(id), DireccionDTO.class);
    }

    @Override
    public DireccionDTO create(DireccionDTO direccion) {
        Direccion dir = MapperUtils.EntityFromDto(direccion, Direccion.class);
        dir = direccionRepository.save(dir);
        return MapperUtils.DtoFromEntity(dir, DireccionDTO.class);
    }
    
}
