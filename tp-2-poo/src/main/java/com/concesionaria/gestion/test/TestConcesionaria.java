
package com.concesionaria.gestion.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import com.concesionaria.gestion.Auto;
import com.concesionaria.gestion.Moto;
import com.concesionaria.gestion.Vehiculo;

public class TestConcesionaria {

        public static void main(String[] args) {

                List<Vehiculo> vehiculos = cargarVehiculos();

                // Mostrar todos los vehículos
                vehiculos.stream().forEach(System.out::println);

                System.out.println("=============================");

                // Vehículo más caro
                Vehiculo masCaro = vehiculos.stream()
                                .max(Comparator.comparingDouble(Vehiculo::getPrecio))
                                .get();

                // Vehículo más barato
                Vehiculo masBarato = vehiculos.stream()
                                .min(Comparator.comparingDouble(Vehiculo::getPrecio))
                                .get();

                // Vehículo cuyo modelo contiene la letra Y
                Vehiculo vehiculoConY = vehiculos.stream()
                                .filter(v -> v.modeloContiene('Y'))
                                .findFirst()
                                .get();

                System.out.println("Vehículo más caro: "
                                + masCaro.getMarca() + " " + masCaro.getModelo());

                System.out.println("Vehículo más barato: "
                                + masBarato.getMarca() + " " + masBarato.getModelo());

                System.out.println("Vehículo que contiene en el modelo la letra ‘Y’: "
                                + vehiculoConY.getMarca() + " "
                                + vehiculoConY.getModelo() + " $"
                                + String.format(Locale.forLanguageTag("es-AR"),
                                                "%,.2f", vehiculoConY.getPrecio()));

                System.out.println("=============================");

                // Ordenar por precio de mayor a menor
                Collections.sort(vehiculos,
                                Comparator.comparingDouble(Vehiculo::getPrecio).reversed());

                System.out.println("Vehículos ordenados por precio de mayor a menor:");

                vehiculos.stream()
                                .map(v -> v.getMarca() + " " + v.getModelo())
                                .forEach(System.out::println);

                System.out.println("=============================");

                // Orden natural: marca, modelo y precio
                Collections.sort(vehiculos);

                System.out.println("Vehículos ordenados por orden natural (marca, modelo, precio):");

                vehiculos.stream().forEach(System.out::println);
        }

        // Único método de carga
        public static List<Vehiculo> cargarVehiculos() {

                List<Vehiculo> vehiculos = new ArrayList<>();

                vehiculos.add(new Auto("Peugeot", "206", 200000, 4));
                vehiculos.add(new Moto("Honda", "Titan", 60000, 125));
                vehiculos.add(new Auto("Peugeot", "208", 250000, 5));
                vehiculos.add(new Moto("Yamaha", "YBR", 80500.50, 160));

                return vehiculos;
        }
}
