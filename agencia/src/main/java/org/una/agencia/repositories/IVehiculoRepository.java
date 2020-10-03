/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.agencia.entities.Vehiculo;

/**
 *
 * @author Jeffry
 */
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v FROM Vehiculo v LEFT JOIN v.grupo g WHERE g.nombre = :nombreGrupo AND v.estado = :estado")
    public List<Vehiculo> findByNombreGrupoAndEstado(@Param("nombreGrupo") String nombreGrupo, @Param("estado")boolean estado);
    
}
