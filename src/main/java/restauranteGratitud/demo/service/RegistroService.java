/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restauranteGratitud.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restauranteGratitud.demo.DTO.RegistroUsuarioDto;
import restauranteGratitud.demo.dao.TipoIdentificacionDAO;
import restauranteGratitud.demo.dao.UsuarioDAO;
import restauranteGratitud.demo.entidades.Direccion;
import restauranteGratitud.demo.entidades.TipoIdentificacion;
import restauranteGratitud.demo.entidades.Usuario;

/**
 *
 * @author Usuario
 */
@Service
public class RegistroService {

    @Autowired
    UsuarioDAO usuarioDAO;

    @Autowired
    TipoIdentificacionDAO identificacionDAO;

    public RegistroService() {
    }

    public RegistroService(UsuarioDAO usuarioDAO, TipoIdentificacionDAO identificacionDAO) {
        this.usuarioDAO = usuarioDAO;
        this.identificacionDAO = identificacionDAO;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public TipoIdentificacionDAO getIdentificacionDAO() {
        return identificacionDAO;
    }

    public void setIdentificacionDAO(TipoIdentificacionDAO identificacionDAO) {
        this.identificacionDAO = identificacionDAO;
    }

    public void RegistrarUsuario(RegistroUsuarioDto usuarioDto) {

        Usuario usuario = new Usuario();

        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellidoP(usuarioDto.getApellidoP());
        usuario.setApellidoM(usuarioDto.getApellidoM());
        usuario.setContrasenia(usuarioDto.getContrasenia());
        usuario.setFechaNacimiento(usuarioDto.getFechaNacimiento());
        usuario.setFechaRegistro(LocalDate.now());
        usuario.setTelefono(usuarioDto.getTelefono());
        usuario.setGmail(usuarioDto.getGmail());
        usuario.setNumeroDni(usuarioDto.getNumeroDni());

        TipoIdentificacion tipoIdentificacion = identificacionDAO
                .findByNombre(usuarioDto.getTipoIdentificacionId())
                .orElseThrow(() -> new RuntimeException("Tipo de identificación no encontrado"));

        Direccion direccion = new Direccion();
        direccion.setPais(usuarioDto.getPais());
        direccion.setDepartamento(usuarioDto.getDepartamento());
        direccion.setCiudad(usuarioDto.getCiudad());
        direccion.setBarrio(usuarioDto.getBarrio());

        usuario.setDireccion(direccion);
        usuario.setTipoIdentificacion(tipoIdentificacion);

        usuarioDAO.save(usuario);

    }

    public List<Usuario> obtenerAllUsers() {
        return usuarioDAO.findAll();
    }

    public Usuario getUserById(int id) {
        return usuarioDAO.findById(id).get();
    }
}
