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
import org.una.agencia.dto.CiudadDTO;
import org.una.agencia.repositories.ICiudadRepository;
import org.una.agencia.utils.ServiceConvertionHelper;
 

/**
 *
 * @author Luis
 */
@Service
public class CiudadServiceImplementation implements ICiudadService{

    @Autowired
    private ICiudadRepository ciudadRepository;
    
    @Override
    public Optional<List<CiudadDTO>> findAll() {
        return ServiceConvertionHelper.findList(ciudadRepository.findAll(), CiudadDTO.class);
    }

    @Override
    public Optional<CiudadDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(ciudadRepository.findById(id), CiudadDTO.class);
    }
    
}
