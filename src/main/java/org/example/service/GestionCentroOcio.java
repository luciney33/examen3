package org.example.service;

import org.example.domain.CentroOcio;
import org.example.domain.ParqueAtracciones;

import java.util.List;
import java.util.Map;

public interface GestionCentroOcio {
    public List<CentroOcio> listarcentros();
    public boolean addCentro(CentroOcio centro);
    public List<CentroOcio> getOrdenadosPorProvinciaYFecha();
    public Map<String, List<CentroOcio>> obtenerCentrosPorProvincia(List<CentroOcio> centros);
    public boolean añadirServicioZoo(int id, String servicio);
    public List<ParqueAtracciones> obtenerParquesOrdenados(int edad, boolean esFestivo);
    public int eliminarCentrosPorAnyo(int anyo);
}
