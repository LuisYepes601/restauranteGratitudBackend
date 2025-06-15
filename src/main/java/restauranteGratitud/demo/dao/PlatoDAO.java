/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restauranteGratitud.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restauranteGratitud.demo.entidades.Plato;

/**
 *
 * @author Usuario
 */
@Repository
public interface PlatoDAO extends JpaRepository<Plato, Integer> {

}
