package org.example.domain;


import org.example.common.ExcepcionValoraciones;

import java.util.ArrayList;
import java.util.List;

public abstract class CentroOcio {
    private int id;
    private String nombre;
    private double precioEntrada;
    private String provincia;
    private int anyoConstruccion;
    private String correoAtencion;
    private List<Integer> valoraciones;

    public CentroOcio(int anyoConstruccion, String correoAtencion, int id, String nombre, double precioEntrada, String provincia, List<Integer> valoraciones) {
        this.anyoConstruccion = anyoConstruccion;
        this.correoAtencion = correoAtencion;
        this.id = id;
        this.nombre = nombre;
        this.precioEntrada = precioEntrada;
        this.provincia = provincia;
        this.valoraciones = new ArrayList<>();
    }

    protected CentroOcio() {
    }

    public int getAnyoConstruccion() {
        return anyoConstruccion;
    }

    public void setAnyoConstruccion(int anyoConstruccion) {
        this.anyoConstruccion = anyoConstruccion;
    }

    public String getCorreoAtencion() {
        return correoAtencion;
    }

    public void setCorreoAtencion(String correoAtencion) {
        this.correoAtencion = correoAtencion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public List<Integer> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<Integer> valoraciones) {
        this.valoraciones = valoraciones;
    }
    public void añadirValoracion(int n) throws ExcepcionValoraciones{
        if (n < 1 || n > 5) {
            throw new ExcepcionValoraciones();
        }
        valoraciones.add(n);
    }

    public abstract double calcularPrecioRealEntrada(int edad, boolean esFestivo);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id);
        sb.append(";");
        sb.append(this.nombre);
        sb.append(";");
        sb.append(this.precioEntrada);
        sb.append(";");
        sb.append(this.provincia);
        sb.append(";");
        sb.append(this.anyoConstruccion);
        sb.append(";");
        sb.append(this.correoAtencion);
        sb.append(";");
        sb.append(this.valoraciones);
        return sb.toString();
    }
}
