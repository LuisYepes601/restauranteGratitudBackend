/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restauranteGratitud.demo.DTO;

/**
 *
 * @author Usuario
 */
public class DetallePedidoDTO {

    private int id; // id del plato
    private int cantidad;
    private double precio; // opcional si quieres enviar el precio también
    private int id_plato;

    public DetallePedidoDTO(int id, int cantidad, double precio, int id_plato) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.id_plato = id_plato;
    }

    public DetallePedidoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }
}
