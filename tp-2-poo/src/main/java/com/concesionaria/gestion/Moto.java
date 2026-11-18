
package com.concesionaria.gestion;

import java.util.Locale;

import lombok.Getter;

@Getter
public class Moto extends Vehiculo {

    private final int cilindrada;

    public Moto(String marca, String modelo, double precio, int cilindrada) {
        super(marca, modelo, precio, false, null);
        this.cilindrada = cilindrada;
    }

    @Override
    public String obtenerCaracteristicas() {
        return "Cilindrada: " + cilindrada + " c";
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
