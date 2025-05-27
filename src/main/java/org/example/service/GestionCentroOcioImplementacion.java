package org.example.service;

import org.example.dao.CentroDaoImplementacion;
import org.example.domain.CentroOcio;
import org.example.domain.ParqueAtracciones;

import java.util.List;
import java.util.Map;

public class GestionCentroOcioImplementacion implements GestionCentroOcio{
    private CentroDaoImplementacion gestion;

    @Override
    public List<CentroOcio> listarcentros() {
        return gestion.listarcentros();
    }

    @Override
    public boolean addCentro(CentroOcio centro) {
        return gestion.addCentro(centro);
    }

    @Override
    public List<CentroOcio> getOrdenadosPorProvinciaYFecha() {
        return gestion.getOrdenadosPorProvinciaYFecha();
    }

    @Override
    public Map<String, List<CentroOcio>> obtenerCentrosPorProvincia(List<CentroOcio> centros) {
        return gestion.obtenerCentrosPorProvincia(centros);
    }

    @Override
    public boolean añadirServicioZoo(int id, String servicio) {
        return gestion.añadirServicioZoo(servicio);
    }

    @Override
    public List<ParqueAtracciones> obtenerParquesOrdenados(int edad, boolean esFestivo) {
        return gestion.obtenerParquesOrdenados(edad,esFestivo);
    }

    @Override
    public int eliminarCentrosPorAnyo(int anyo) {
        return gestion.eliminarCentrosPorAnyo(anyo);
    }
}
