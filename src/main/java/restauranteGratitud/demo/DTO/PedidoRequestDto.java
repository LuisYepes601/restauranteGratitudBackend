/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restauranteGratitud.demo.DTO;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class PedidoRequestDto {

    private int usuarioId;
    private List<DetallePedidoDTO> detalles;

    public PedidoRequestDto() {
    }

    public PedidoRequestDto(int usuarioId, List<DetallePedidoDTO> detalles) {
        this.usuarioId = usuarioId;
        this.detalles = detalles;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<DetallePedidoDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedidoDTO> detalles) {
        this.detalles = detalles;
    }
}
