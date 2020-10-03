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
import org.una.agencia.dto.ClienteDTO;
import org.una.agencia.entities.Alquiler;
import org.una.agencia.entities.Cliente;
import org.una.agencia.repositories.IClienteRepository;
import org.una.agencia.utils.MapperUtils;
import org.una.agencia.utils.ServiceConvertionHelper;


/**
 *
 * @author Luis
 */
@Service
public class ClienteServiceImplementation implements IClienteService {
    
    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public Optional<List<ClienteDTO>> findAll() {
        return ServiceConvertionHelper.findList(clienteRepository.findAll(), ClienteDTO.class);
    }

    @Override
    public Optional<ClienteDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(clienteRepository.findById(id), ClienteDTO.class);
    }

    @Override
    public ClienteDTO create(ClienteDTO cliente) {
        Cliente clie = MapperUtils.EntityFromDto(cliente, Cliente.class);
        clie = clienteRepository.save(clie);
        return MapperUtils.DtoFromEntity(clie, ClienteDTO.class);
    }
}
