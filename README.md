# poo-tp2
Segundo Trabajo Obligatorio POO
# Gestión de Concesionaria

Este proyecto consiste en un programa en Java que simula una concesionaria de vehículos.

Se pueden cargar autos y motos, mostrar sus datos y realizar distintas operaciones con ellos.

### Clases principales

- **Vehiculo:** es la clase abstracta que contiene los atributos y métodos comunes a todos los vehículos.
- **Auto:** representa un auto y agrega la cantidad de puertas.
- **Moto:** representa una moto y agrega la cilindrada.
- **IVenta:** es la interfaz que permite registrar una venta y consultar si el vehículo fue vendido y en qué fecha.
- **TestConcesionaria:** contiene el método principal y la carga de los vehículos.

### ¿Qué hace el programa?

- Muestra todos los vehículos.
- Busca el más caro y el más barato.
- Busca vehículos cuyo modelo contiene una letra determinada.
- Ordena los vehículos por precio.
- Ordena los vehículos por marca, modelo y precio.

### Conceptos utilizados

En el trabajo se aplican conceptos de programación orientada a objetos, como herencia, abstracción, encapsulamiento y polimorfismo. También se utilizan interfaces, `Comparable`, Collections y Stream API.
