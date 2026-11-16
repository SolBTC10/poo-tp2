
package com.concesionaria.gestion.interfaces;

import java.util.List;

import com.concesionaria.gestion.Vehiculo;

public interface IServicio {

    void cargarVehiculos();

    void agregarVehiculo(Vehiculo vehiculo);

    List<Vehiculo> obtenerVehiculos();

    Vehiculo obtenerMasCaro();

    Vehiculo obtenerMasBarato();

    Vehiculo buscarVehiculoConLetra(char letra);

    List<Vehiculo> ordenarPorPrecio();

    List<Vehiculo> ordenarPorOrdenNatural();

}
