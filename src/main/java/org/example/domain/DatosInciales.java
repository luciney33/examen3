package org.example.domain;

import org.example.common.Consonantes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DatosInciales {
    public static List<CentroOcio> cargarcentros(){
        List<CentroOcio> centros = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i <4; i++) { //este for es para que me cree 4 objetos directos y no tenerlos que hacer a mano
            int id = r.nextInt(4);
            String nombre = Consonantes.NOMBRES[r.nextInt(Consonantes.NOMBRES.length)];
            double precioEntrada = 20;
            String provincia = Consonantes.PROVINCIAS[r.nextInt(Consonantes.PROVINCIAS.length)];
            int anyoConstruccion = r.nextInt(2025);
            String correoAtencion = Consonantes.CORREOS[r.nextInt(Consonantes.CORREOS.length)];
            List<Integer> valoraciones = List.of(4, 5, 3);
            int edadMinima = 12;
            ParqueAtracciones parque1 = new ParqueAtracciones(id,nombre,precioEntrada,provincia,anyoConstruccion,correoAtencion,valoraciones,10);
            centros.add(parque1);
        }
        //zoo
        for (int i = 0; i <4; i++) { //este for es para que me cree 4 objetos directos y no tenerlos que hacer a mano
            int id = 4 + r.nextInt(8);
            String nombre = Consonantes.NOMBRES[r.nextInt(Consonantes.NOMBRES.length)];
            double precioEntrada = 10;
            String provincia = Consonantes.PROVINCIAS[r.nextInt(Consonantes.PROVINCIAS.length)];
            int anyoConstruccion = r.nextInt(2025);
            String correoAtencion = Consonantes.CORREOS[r.nextInt(Consonantes.CORREOS.length)];
            List<Integer> valoraciones = List.of(3, 4, 5);
            List<String> servicios = new ArrayList<>();
            servicios.add("Delfinario");
            servicios.add("Exhibición aves");
            Zoo zoo = new Zoo(id, nombre, precioEntrada, provincia, anyoConstruccion, correoAtencion
            );
            centros.add(zoo);
        }
        return centros;

    }
}
