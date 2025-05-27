package org.example.common;

public class Comprobaciones {
    public static void comprobarPrecioParque(double precio) throws ExcepcionParqueEntrada {
        if (precio < 15 || precio > 25) {
            throw new ExcepcionParqueEntrada("Precio del parque debe estar entre 15 y 25");
        }
    }

    public static void comprobarPrecioZoo(double precio) throws ExcepcionZooEntrada {
        if (precio < 10 || precio > 20) {
            throw new ExcepcionZooEntrada("Precio del zoo debe estar entre 10 y 20");
        }
    }

    public static void comprobarValoraciones(int num) throws ExcepcionValoraciones {
        if (num < 1 || num > 5) {
            throw new ExcepcionValoraciones("La valoración debe estar entre 1 y 5");
        }
    }
}
