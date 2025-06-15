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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restauranteGratitud.demo.DTO.RegistroUsuarioDto;
import restauranteGratitud.demo.entidades.Usuario;
import restauranteGratitud.demo.service.RegistroService;

/**
 *
 * @author Usuario
 */
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("registrar")
public class RegistroController {

    @Autowired
    RegistroService registroService;

    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    public RegistroController() {
    }

    public RegistroService getRegistroService() {
        return registroService;
    }

    public void setRegistroService(RegistroService registroService) {
        this.registroService = registroService;
    }

    @PostMapping("usuario")
    public ResponseEntity registrarUsuario(@RequestBody RegistroUsuarioDto registroUsuarioDto) {

        registroService.RegistrarUsuario(registroUsuarioDto);
        return ResponseEntity.ok("\"Usuario registrado exitosamente\"");

    }

    @GetMapping("get/all/users")
    public ResponseEntity obtenerAllUsers() {
        return ResponseEntity.ok().body(registroService.obtenerAllUsers());
    }

    @GetMapping("get/user/ByiD/{id}")
    public ResponseEntity getUserById(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().body(registroService.getUserById(id));
    }

}
