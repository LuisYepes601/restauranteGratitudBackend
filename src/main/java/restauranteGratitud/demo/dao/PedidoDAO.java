/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restauranteGratitud.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import restauranteGratitud.demo.entidades.Pedido;

/**
 *
 * @author Usuario
 */
public interface PedidoDAO extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByUsuarioId(int usuarioId);

}
