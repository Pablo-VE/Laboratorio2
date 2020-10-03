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
import org.una.agencia.dto.OficinaDTO;
import org.una.agencia.entities.Oficina;
import org.una.agencia.repositories.IOficinaRepository;
import org.una.agencia.services.IOficinaService;
import org.una.agencia.utils.MapperUtils;
import org.una.agencia.utils.ServiceConvertionHelper;

/**
 *
 * @author Luis
 */
@Service
public class OficinaServiceImplementation implements IOficinaService {
    
    @Autowired
    private IOficinaRepository oficinaRepository;

    @Override
    public Optional<List<OficinaDTO>> findAll() {
        return ServiceConvertionHelper.findList(oficinaRepository.findAll(), OficinaDTO.class);
    }

    @Override
    public Optional<OficinaDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(oficinaRepository.findById(id), OficinaDTO.class);
    }

    @Override
    public OficinaDTO create(OficinaDTO oficina) {
        Oficina ofi = MapperUtils.EntityFromDto(oficina, Oficina.class);
        ofi = oficinaRepository.save(ofi);
        return MapperUtils.DtoFromEntity(ofi, OficinaDTO.class);
    }
    
}
