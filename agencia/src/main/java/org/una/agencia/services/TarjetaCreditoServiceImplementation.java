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
import org.una.agencia.dto.TarjetaCreditoDTO;
import org.una.agencia.repositories.ITarjetaCreditoRepository;
import org.una.agencia.utils.ServiceConvertionHelper;

/**
 *
 * @author Luis
 */
@Service
public class TarjetaCreditoServiceImplementation implements ITarjetaCreditoService{

    @Autowired
    private ITarjetaCreditoRepository tarjetaCreditoRepository;
    
    @Override
    public Optional<List<TarjetaCreditoDTO>> findAll() {
        return ServiceConvertionHelper.findList(tarjetaCreditoRepository.findAll(), TarjetaCreditoDTO.class);
    }

    @Override
    public Optional<TarjetaCreditoDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(tarjetaCreditoRepository.findById(id), TarjetaCreditoDTO.class);
    }
    
    
    
}
