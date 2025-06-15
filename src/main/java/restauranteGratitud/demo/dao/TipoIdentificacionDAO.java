/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restauranteGratitud.demo.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import restauranteGratitud.demo.entidades.TipoIdentificacion;

/**
 *
 * @author Usuario
 */
public interface TipoIdentificacionDAO extends JpaRepository<TipoIdentificacion, Integer> {

    Optional<TipoIdentificacion> findByNombre(String nombre);
}
