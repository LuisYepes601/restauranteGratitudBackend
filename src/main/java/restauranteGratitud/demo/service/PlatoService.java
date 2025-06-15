/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restauranteGratitud.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restauranteGratitud.demo.dao.PlatoDAO;
import restauranteGratitud.demo.entidades.Plato;

/**
 *
 * @author Usuario
 */
@Service
public class PlatoService {

    @Autowired
    PlatoDAO platoDAO;

    public PlatoService() {
    }

    public PlatoService(PlatoDAO platoDAO) {
        this.platoDAO = platoDAO;
    }

    public void createPlato(Plato plato) {

        Plato plato1 = new Plato();
        plato1.setNombre(plato.getNombre());
        plato1.setDescripcion(plato.getDescripcion());
        plato1.setEstado(plato.isEstado());
        plato1.setImagen(plato.getImagen());
        plato1.setPrecio(plato.getPrecio());
        plato1.setTextura(plato.getTextura());
        plato1.setSabor(plato.getSabor());
        plato1.setPorcion(plato.getPorcion());
        plato1.setPresentacion(plato.getPresentacion());
        plato1.setPeso(plato.getPeso());

        platoDAO.save(plato1);

    }

    public Plato buscarPlatoPorId(int id) {

        Optional<Plato> plato = platoDAO.findById(id);
        Plato platoActual = plato.get();

        return platoActual;
    }

    public List<Plato> getPlatosAll() {
        List<Plato> platos = platoDAO.findAll();

        return platos;
    }

}
