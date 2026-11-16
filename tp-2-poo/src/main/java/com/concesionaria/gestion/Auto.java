
package com.concesionaria.gestion;

import java.util.Locale;

import lombok.Getter;

@Getter
public class Auto extends Vehiculo {

    private final int puertas;

    public Auto(String marca, String modelo, double precio, int puertas) {
        super(marca, modelo, precio, false, null);
        this.puertas = puertas;
    }

    @Override
    public String obtenerCaracteristicas() {
        return "Puertas: " + puertas;
    }

    @Override
    public String toString() {
        return "Marca: " + getMarca()
                + " // Modelo: " + getModelo()
                + " // " + obtenerCaracteristicas()
                + " // Precio: $" + String.format(
                        Locale.forLanguageTag("es-AR"),
                        "%,.2f", getPrecio());
    }
}
