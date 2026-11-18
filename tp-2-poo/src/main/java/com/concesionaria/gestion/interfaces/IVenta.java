package com.concesionaria.gestion.interfaces;

import java.time.LocalDate;

public interface IVenta {

    void registrarVenta(LocalDate fechaVenta);

    boolean estaVendido();

    LocalDate getFechaVenta();

}