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
import org.una.agencia.dto.TamanoVehiculoDTO;
import org.una.agencia.entities.TamanoVehiculo;
import org.una.agencia.repositories.ITamanoVehiculoRepository;
import org.una.agencia.utils.MapperUtils;
import org.una.agencia.utils.ServiceConvertionHelper;

/**
 *
 * @author Luis
 */
@Service
public class TamanoVehiculoServiceImplementation implements ITamanoVehiculoService {

    @Autowired
    private ITamanoVehiculoRepository tamanoVehiculoRepository;
    
    @Override
    public Optional<List<TamanoVehiculoDTO>> findAll() {
        return ServiceConvertionHelper.findList(tamanoVehiculoRepository.findAll(), TamanoVehiculoDTO.class);
    }

    @Override
    public Optional<TamanoVehiculoDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(tamanoVehiculoRepository.findById(id), TamanoVehiculoDTO.class);
    }

    @Override
    public TamanoVehiculoDTO create(TamanoVehiculoDTO tamanoVehiculo) {
        TamanoVehiculo tama = MapperUtils.EntityFromDto(tamanoVehiculo, TamanoVehiculo.class);
        tama = tamanoVehiculoRepository.save(tama);
        return MapperUtils.DtoFromEntity(tama, TamanoVehiculoDTO.class);
    }
    
}
