/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restauranteGratitud.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restauranteGratitud.demo.DTO.UsuarioLogin;
import restauranteGratitud.demo.dao.UsuarioDAO;
import restauranteGratitud.demo.entidades.Usuario;

/**
 *
 * @author Usuario
 */
@Service
public class LloguinService {

    @Autowired
    UsuarioDAO usuarioDAO;

    public LloguinService() {
    }

    public LloguinService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario inciarSesion(UsuarioLogin usuarioLogin) {

        Usuario usuario = usuarioDAO.findUserByGmail(usuarioLogin.getEmail());

        if (usuario == null) {
            return null; // Usuario no existe
        }

        if (!usuario.getContrasenia().equals(usuarioLogin.getPassword())) {
            return null; // Contraseña incorrecta
        }

        return usuario;

    }
}
