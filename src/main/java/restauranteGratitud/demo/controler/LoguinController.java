/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restauranteGratitud.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restauranteGratitud.demo.DTO.UsuarioLogin;
import restauranteGratitud.demo.entidades.Usuario;
import restauranteGratitud.demo.service.LloguinService;

/**
 *
 * @author Usuario
 */
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("login")
public class LoguinController {

    @Autowired
    LloguinService lloguinService;

    public LoguinController() {
    }

    public LoguinController(LloguinService lloguinService) {
        this.lloguinService = lloguinService;
    }

    public LloguinService getLloguinService() {
        return lloguinService;
    }

    public void setLloguinService(LloguinService lloguinService) {
        this.lloguinService = lloguinService;
    }

    @PostMapping("verificarCredenciales")
    public ResponseEntity iniciarSesion(@RequestBody UsuarioLogin usuarioLogin) {
        Usuario usuario = lloguinService.inciarSesion(usuarioLogin);

        if (usuario == null) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(usuario); // o puedes devolver un objeto con mensaje
        }

        return ResponseEntity.ok(usuario);

    }
}
