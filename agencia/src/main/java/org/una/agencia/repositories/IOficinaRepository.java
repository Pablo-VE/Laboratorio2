/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.agencia.entities.Oficina;

/**
 *
 * @author Pablo-VE
 */
public interface IOficinaRepository extends JpaRepository<Oficina, Long>  {
    
}
