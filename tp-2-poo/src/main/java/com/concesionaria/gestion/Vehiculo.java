
package com.concesionaria.gestion;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

import com.concesionaria.gestion.interfaces.IVenta;

@Getter
@Setter
@AllArgsConstructor
public abstract class Vehiculo implements Comparable<Vehiculo>, IVenta {

    private String marca;
    private String modelo;
    private double precio;
    private boolean vendido;
    private LocalDate fechaVenta;

    @Override
    public int compareTo(Vehiculo otro) {

        int resultado = this.marca.compareTo(otro.marca);

        if (resultado == 0) {
            resultado = this.modelo.compareTo(otro.modelo);
        }

        if (resultado == 0) {
            resultado = Double.compare(this.precio, otro.precio);
        }

        return resultado;
    }

    public boolean modeloContiene(char letra) {
        return modelo.toUpperCase().contains(
                String.valueOf(letra).toUpperCase());
    }

    @Override
    public void registrarVenta(LocalDate fechaVenta) {

        if (vendido) {
            throw new IllegalStateException(
                    "El vehículo ya fue vendido.");
        }

        if (fechaVenta == null) {
            throw new IllegalArgumentException(
                    "La fecha de venta no puede ser nula.");
        }

        this.fechaVenta = fechaVenta;
        this.vendido = true;
    }

    @Override
    public boolean estaVendido() {
        return vendido;
    }

    public abstract String obtenerCaracteristicas();

}
