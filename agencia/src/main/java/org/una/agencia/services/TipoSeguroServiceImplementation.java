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
import org.una.agencia.dto.TipoSeguroDTO;
import org.una.agencia.entities.TipoSeguro;
import org.una.agencia.repositories.ITipoSeguroRepository;
import org.una.agencia.utils.MapperUtils;
import org.una.agencia.utils.ServiceConvertionHelper;

/**
 *
 * @author Luis
 */
@Service
public class TipoSeguroServiceImplementation implements ITipoSeguroService {

    @Autowired
    private ITipoSeguroRepository tipoSeguroRepository;
    
    @Override
    public Optional<List<TipoSeguroDTO>> findAll() {
        return ServiceConvertionHelper.findList(tipoSeguroRepository.findAll(), TipoSeguroDTO.class);
    }

    @Override
    public Optional<TipoSeguroDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(tipoSeguroRepository.findById(id), TipoSeguroDTO.class);
    }

    @Override
    public TipoSeguroDTO create(TipoSeguroDTO tipoSeguro) {
        TipoSeguro seguro = MapperUtils.EntityFromDto(tipoSeguro, TipoSeguro.class);
        seguro = tipoSeguroRepository.save(seguro);
        return MapperUtils.DtoFromEntity(seguro, TipoSeguroDTO.class);
    }
    
}
