/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restauranteGratitud.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restauranteGratitud.demo.DTO.PedidoRequestDto;
import restauranteGratitud.demo.DTO.PedidoResponseDto;
import restauranteGratitud.demo.entidades.Pedido;
import restauranteGratitud.demo.service.PedidoSevice;

/**
 *
 * @author Usuario
 */
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    PedidoSevice pedidoSevice;

    public PedidoController(PedidoSevice pedidoSevice) {
        this.pedidoSevice = pedidoSevice;
    }

    public PedidoSevice getPedidoSevice() {
        return pedidoSevice;
    }

    public void setPedidoSevice(PedidoSevice pedidoSevice) {
        this.pedidoSevice = pedidoSevice;
    }

    public PedidoController() {
    }

    @PostMapping("crear")
    public ResponseEntity crearPedido(@RequestBody PedidoRequestDto dto) {
        PedidoResponseDto pedido = pedidoSevice.crearPedido(dto);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("obtner/ByUsuario/{id}")

    public ResponseEntity obtenerPedidosPorUsuario(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(pedidoSevice.ObtenerPedidosUusuarioById(id));
    }
}
