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
import org.una.agencia.entities.Alquiler;

/**
 *
 * @author Jeffry
 */
public interface IAlquilerRepository extends JpaRepository<Alquiler, Long>{
    @Query("SELECT a FROM Alquiler a LEFT JOIN a.tarjetaCredito t LEFT JOIN a.vehiculo v WHERE UPPER(t.nombreTitular) like  CONCAT('%', UPPER(:nombre), '%') AND UPPER(v.matricula) like  CONCAT('%', UPPER(:matricula), '%')")
    public List<Alquiler> findByTitularTarjetaAndMatriculaVehiculo(@Param("nombre") String nombre, @Param("matricula")String matricula);
    
    @Query("SELECT a FROM Alquiler a LEFT JOIN a.tarjetaCredito t LEFT JOIN a.vehiculo v LEFT JOIN t.cliente c WHERE UPPER(c.cedula) like  CONCAT('%', UPPER(:cedula), '%') AND UPPER(v.matricula) like  CONCAT('%', UPPER(:matricula), '%')")
    public List<Alquiler> findByCedulaClienteAndMatriculaVehiculo(@Param("cedula") String cedula, @Param("matricula")String matricula);
    
}
