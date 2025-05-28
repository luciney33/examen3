package org.example.dao;

import org.example.domain.CentroOcio;
import org.example.domain.DatosInciales;
import org.example.domain.ParqueAtracciones;
import org.example.domain.Zoo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CentroDaoImplementacion implements CentroDao{
    private List<CentroOcio> centros = DatosInciales.cargarcentros();
    @Override
    public List<CentroOcio> listarcentros() {
        return centros;
    }

    @Override
    public boolean addCentro(CentroOcio centro) {
        boolean ayadirSi= false;
        boolean exite = centros.stream().anyMatch(centroOcio -> centroOcio.getId() == centro.getId());
        if (exite){
            centros.add(centro);
            ayadirSi=true;
        }else {
            ayadirSi=false;
        }
        return ayadirSi;
    }

    @Override
    public List<CentroOcio> getOrdenadosPorProvinciaYFecha() {
        return centros.stream().sorted(Comparator.comparing(CentroOcio::getProvincia).thenComparing(CentroOcio::getAnyoConstruccion)).collect(Collectors.toList());
    }

    @Override
    public Map<String, List<CentroOcio>> obtenerCentrosPorProvincia(List<CentroOcio> centros) {
        return centros.stream().collect(Collectors.groupingBy(CentroOcio::getProvincia));
    }

    @Override
    public boolean añadirServicioZoo(int idZoo, String servicio) {
        for (CentroOcio c : centros) {
            if (c instanceof Zoo) {
                Zoo z = (Zoo) c;
                if (z.getId() == idZoo) {
                    if (!z.getServicios().contains(servicio)) {
                        z.getServicios().add(new Zoo(servicio));
                        return true; // Servicio añadido correctamente
                    } else {
                        return false; // Ya existía ese servicio
                    }
                }
            }
        }
        return false; // No se encontró el zoológico con ese ID
    }

    @Override
    public List<ParqueAtracciones> obtenerParquesOrdenados(int edad, boolean esFestivo) {
        return centros.stream().filter(c -> c instanceof ParqueAtracciones).map(c -> (ParqueAtracciones) c)
                .sorted(Comparator.comparing(ParqueAtracciones::getProvincia).thenComparing(p -> p.calcularPrecioRealEntrada(edad, esFestivo)))
                .collect(Collectors.toList());
    }

    @Override
    public int eliminarCentrosPorAnyo(int anyo) {
        //int inicial = centros.size();
        //centros.removeIf(c -> c.getAnyoConstruccion() < anyo);
        //return inicial - centros.size();

        int contador = 0;
        Iterator<CentroOcio> it = centros.iterator();

        while (it.hasNext()) {
            CentroOcio centro = it.next();
            if (centro.getAnyoConstruccion() < anyo) {
                it.remove(); // elimina el elemento actual de forma segura
                contador++;
            }
        }

        return contador; // devuelve cuántos centros se han eliminado
    }
}
