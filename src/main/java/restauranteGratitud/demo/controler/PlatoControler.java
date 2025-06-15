/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restauranteGratitud.demo.controler;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restauranteGratitud.demo.entidades.Plato;
import restauranteGratitud.demo.service.PlatoService;

/**
 *
 * @author Usuario
 */
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("plato")
public class PlatoControler {

    @Autowired
    PlatoService platoService;

    public PlatoControler() {
    }

    public PlatoControler(PlatoService platoService) {
        this.platoService = platoService;

    }

    @PostMapping("crear")
    public ResponseEntity<Plato> crearPlato(@RequestBody Plato plato) {

        platoService.createPlato(plato);
        return ResponseEntity.ok(plato);

    }

    @GetMapping("findById/{id}")
    public ResponseEntity buscarPlatoPorId(@PathVariable(name = "id") int id) {
        if (id > 0) {
            return ResponseEntity.ok(platoService.buscarPlatoPorId(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
        }

    }

    @GetMapping("obtenenerPlatos")
    public ResponseEntity obtenenerPlatos() {

        List<Plato> platos = platoService.getPlatosAll();

        if (platos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay platos disponibles");
        }
        return ResponseEntity.ok(platos);
    }

}
