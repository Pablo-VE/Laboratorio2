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
import org.una.agencia.dto.GrupoVehiculoDTO;
import org.una.agencia.entities.GrupoVehiculo;
import org.una.agencia.repositories.IGrupoVehiculoRepository;
import org.una.agencia.utils.MapperUtils;
import org.una.agencia.utils.ServiceConvertionHelper;

/**
 *
 * @author Luis
 */
@Service
public class GrupoVehiculoServiceImplementation implements IGrupoVehiculoService {
    
    @Autowired
    private IGrupoVehiculoRepository grupoVehiculoRepository;
    
    @Override
    public Optional<List<GrupoVehiculoDTO>> findAll() {
        return ServiceConvertionHelper.findList(grupoVehiculoRepository.findAll(), GrupoVehiculoDTO.class);
    }

    @Override
    public Optional<GrupoVehiculoDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(grupoVehiculoRepository.findById(id), GrupoVehiculoDTO.class);
    }  

    @Override
    public GrupoVehiculoDTO create(GrupoVehiculoDTO grupoVehiculo) {
        GrupoVehiculo grupo = MapperUtils.EntityFromDto(grupoVehiculo, GrupoVehiculo.class);
        grupo = grupoVehiculoRepository.save(grupo);
        return MapperUtils.DtoFromEntity(grupo, GrupoVehiculoDTO.class);
    }
}
