/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restauranteGratitud.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import restauranteGratitud.demo.entidades.DetallePedido;

/**
 *
 * @author Usuario
 */
public interface DetallepedidoDao extends JpaRepository<DetallePedido, Integer> {

}
