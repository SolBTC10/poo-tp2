
package com.concesionaria.gestion.servicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.concesionaria.gestion.Auto;
import com.concesionaria.gestion.Moto;
import com.concesionaria.gestion.Vehiculo;
import com.concesionaria.gestion.interfaces.IServicio;

public class ServicioConcesionaria implements IServicio {

    private final List<Vehiculo> vehiculos;

    public ServicioConcesionaria() {
        this.vehiculos = new ArrayList<>();
        cargarVehiculos();
    }

    // Único método de carga
    @Override
    public void cargarVehiculos() {

        if (!vehiculos.isEmpty()) {
            return;
        }

        vehiculos.add(new Auto("Peugeot", "206", 200000, 4));
        vehiculos.add(new Moto("Honda", "Titan", 60000, 125));
        vehiculos.add(new Auto("Peugeot", "208", 250000, 5));
        vehiculos.add(new Moto("Yamaha", "YBR", 80500.50, 160));
    }

    // Agregar un vehículo
    @Override
    public void agregarVehiculo(Vehiculo vehiculo) {

        if (vehiculo == null) {
            throw new IllegalArgumentException(
                    "El vehículo no puede ser nulo.");
        }

        vehiculos.add(vehiculo);
    }

    // Obtener todos los vehículos
    @Override
    public List<Vehiculo> obtenerVehiculos() {
        return new ArrayList<>(vehiculos);
    }

    // Vehículo más caro
    @Override
    public Vehiculo obtenerMasCaro() {

        return vehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::getPrecio))
                .orElseThrow(() -> new IllegalStateException(
                        "No hay vehículos cargados."));
    }

    // Vehículo más barato
    @Override
    public Vehiculo obtenerMasBarato() {

        return vehiculos.stream()
                .min(Comparator.comparingDouble(Vehiculo::getPrecio))
                .orElseThrow(() -> new IllegalStateException(
                        "No hay vehículos cargados."));
    }

    // Vehículo cuyo modelo contiene una letra
    @Override
    public Vehiculo buscarVehiculoConLetra(char letra) {

        return vehiculos.stream()
                .filter(v -> v.modeloContiene(letra))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "No se encontró ningún vehículo con esa letra."));
    }

    // Ordenar por precio de mayor a menor
    @Override
    public List<Vehiculo> ordenarPorPrecio() {

        List<Vehiculo> ordenados = new ArrayList<>(vehiculos);

        Collections.sort(
                ordenados,
                Comparator.comparingDouble(Vehiculo::getPrecio).reversed()
        );

        return ordenados;
    }

    // Orden natural: marca, modelo y precio
    @Override
    public List<Vehiculo> ordenarPorOrdenNatural() {

        List<Vehiculo> ordenados = new ArrayList<>(vehiculos);

        Collections.sort(ordenados);

        return ordenados;
    }
}
