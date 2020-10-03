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
import org.springframework.transaction.annotation.Transactional;
import org.una.agencia.dto.AlquilerDTO;
import org.una.agencia.entities.Alquiler;
import org.una.agencia.repositories.IAlquilerRepository;
import org.una.agencia.utils.MapperUtils;
import org.una.agencia.utils.ServiceConvertionHelper;

/**
 *
 * @author Luis
 */
@Service
public class AlquilerServiceImplementation implements IAlquilerService {
    
    @Autowired
    private IAlquilerRepository alquilerRepository;
    
    @Override
    public Optional<List<AlquilerDTO>> findAll() {
        return ServiceConvertionHelper.findList(alquilerRepository.findAll(), AlquilerDTO.class);
    }

    @Override
    public Optional<AlquilerDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(alquilerRepository.findById(id), AlquilerDTO.class);
    }
    
    @Override
    public AlquilerDTO create(AlquilerDTO alquiler) {
        Alquiler alqui = MapperUtils.EntityFromDto(alquiler, Alquiler.class);
        alqui = alquilerRepository.save(alqui);
        return MapperUtils.DtoFromEntity(alqui, AlquilerDTO.class);
    }
        
}
