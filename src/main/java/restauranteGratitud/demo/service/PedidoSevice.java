/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restauranteGratitud.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restauranteGratitud.demo.DTO.DetallePedidoDTO;
import restauranteGratitud.demo.DTO.PedidoRequestDto;
import restauranteGratitud.demo.DTO.PedidoResponseDto;
import restauranteGratitud.demo.dao.DetallepedidoDao;
import restauranteGratitud.demo.dao.PedidoDAO;
import restauranteGratitud.demo.dao.PlatoDAO;
import restauranteGratitud.demo.dao.UsuarioDAO;
import restauranteGratitud.demo.entidades.DetallePedido;
import restauranteGratitud.demo.entidades.Pedido;
import restauranteGratitud.demo.entidades.Plato;
import restauranteGratitud.demo.entidades.Usuario;

/**
 *
 * @author Usuario
 */
@Service
public class PedidoSevice {

    @Autowired
    UsuarioDAO usuarioDAO;
    @Autowired
    PlatoDAO plato;
    @Autowired
    DetallepedidoDao detallePedido;
    @Autowired
    PedidoDAO pedidoDAO;

    public PedidoSevice(UsuarioDAO usuarioDAO, PlatoDAO plato, DetallepedidoDao detallePedido, PedidoDAO pedidoDAO) {
        this.usuarioDAO = usuarioDAO;
        this.plato = plato;
        this.detallePedido = detallePedido;
        this.pedidoDAO = pedidoDAO;
    }

    public PedidoSevice() {
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public PedidoDAO getPedidoDAO() {
        return pedidoDAO;
    }

    public void setPedidoDAO(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public PlatoDAO getPlato() {
        return plato;
    }

    public void setPlato(PlatoDAO plato) {
        this.plato = plato;
    }

    public DetallepedidoDao getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(DetallepedidoDao detallePedido) {
        this.detallePedido = detallePedido;
    }

    public PedidoResponseDto crearPedido(PedidoRequestDto pedidoRequestDto) {

        Usuario usuario = usuarioDAO.findById(pedidoRequestDto.getUsuarioId()).get();

        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setFecha(LocalDateTime.now());

        List<DetallePedido> detalles = new ArrayList<>();
        double subtotal = 0;
        double total = 0;

        for (DetallePedidoDTO detallePedido : pedidoRequestDto.getDetalles()) {
            Plato plato = this.plato.findById(detallePedido.getId()).get();
            System.out.println(plato);

            DetallePedido detalle = new DetallePedido();
            detalle.setPlato(plato);
            detalle.setCantidad(detallePedido.getCantidad());
            detalle.setPedido(pedido);

            detalles.add(detalle);

            total += plato.getPrecio() * detallePedido.getCantidad();

            subtotal = plato.getPrecio() * detallePedido.getCantidad();
            detalle.setSubtotal(subtotal);

        }

        pedido.setDetalles(detalles);
        pedido.setTotal(total);

        Pedido pedido1 = pedidoDAO.save(pedido);

        PedidoResponseDto pedidoResponseDto = new PedidoResponseDto();

        pedidoResponseDto.setDetalles(pedidoRequestDto.getDetalles());
        pedidoResponseDto.setFecha(pedido1.getFecha());
        pedidoResponseDto.setTotal(pedido1.getTotal());
        pedidoResponseDto.setId(pedido1.getId());
        return pedidoResponseDto;

    }

    public List<PedidoResponseDto> ObtenerPedidosUusuarioById(int id) {

        List<Pedido> pedidos = pedidoDAO.findByUsuarioId(id);

        List<PedidoResponseDto> pedidosd = new ArrayList<PedidoResponseDto>();

        for (Pedido pedido : pedidos) {

            PedidoResponseDto dto = new PedidoResponseDto();
            dto.setId(pedido.getId());
            dto.setTotal(pedido.getTotal());
            dto.setFecha(pedido.getFecha());

            List<DetallePedidoDTO> detalles = new ArrayList<>();
            for (DetallePedido detallePedido : pedido.getDetalles()) {
                DetallePedidoDTO dTO = new DetallePedidoDTO();
                dTO.setCantidad(detallePedido.getCantidad());
                dTO.setId(detallePedido.getId().intValue());
                dTO.setPrecio(detallePedido.getPlato().getPrecio());
                dTO.setId_plato(detallePedido.getPlato().getId());
                detalles.add(dTO);

            }
            dto.setDetalles(detalles);

            pedidosd.add(dto);
        }

        return pedidosd;

    }
}
