
package com.concesionaria.gestion.test;

import java.util.Locale;

import com.concesionaria.gestion.Vehiculo;
import com.concesionaria.gestion.interfaces.IServicio;
import com.concesionaria.gestion.servicio.ServicioConcesionaria;

public class TestConcesionaria {

    public static void main(String[] args) {

        System.out.println("\n");

        IServicio servicio = new ServicioConcesionaria();

        // Mostrar todos los vehículos
        servicio.obtenerVehiculos()
                .stream()
                .forEach(System.out::println);

        System.out.println();
        System.out.println("=============================");
        System.out.println();

        // Vehículo más caro
        Vehiculo masCaro = servicio.obtenerMasCaro();

        // Vehículo más barato
        Vehiculo masBarato = servicio.obtenerMasBarato();

        // Vehículo cuyo modelo contiene la letra Y
        Vehiculo vehiculoConY = servicio.buscarVehiculoConLetra('Y');

        System.out.println("Vehículo más caro: "
                + masCaro.getMarca() + " " + masCaro.getModelo());

        System.out.println("Vehículo más barato: "
                + masBarato.getMarca() + " " + masBarato.getModelo());

        System.out.println("Vehículo que contiene en el modelo la letra 'Y': "
                + vehiculoConY.getMarca() + " "
                + vehiculoConY.getModelo() + " $"
                + String.format(Locale.forLanguageTag("es-AR"),
                        "%,.2f", vehiculoConY.getPrecio()));

        System.out.println();
        System.out.println("=============================");
        System.out.println();

        // Ordenar por precio de mayor a menor
        System.out.println("Vehículos ordenados por precio de mayor a menor:");

        servicio.ordenarPorPrecio()
                .stream()
                .map(v -> v.getMarca() + " " + v.getModelo())
                .forEach(System.out::println);

        System.out.println("");
        System.out.println("=============================");
        System.out.println("");

        // Orden natural: marca, modelo y precio
        System.out.println("Vehículos ordenados por orden natural (marca, modelo, precio):");

        servicio.ordenarPorOrdenNatural()
                .stream()
                .forEach(System.out::println);

        System.out.println("\n");

    }
}
