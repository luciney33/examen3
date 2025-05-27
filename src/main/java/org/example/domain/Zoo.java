package org.example.domain;

import org.example.common.ExcepcionZooEntrada;

import java.util.ArrayList;
import java.util.List;

public class Zoo extends CentroOcio{
    private List<Zoo> servicios;

    public Zoo(int anyoConstruccion, String correoAtencion, int id, String nombre, double precioEntrada,
               String provincia, List<Integer> valoraciones, List<String> servicios) {
        super(anyoConstruccion, correoAtencion, id, nombre, precioEntrada, provincia, valoraciones);
        this.servicios= new ArrayList<>();
    }

    public Zoo(int id, String nombre, double precioEntrada, String provincia, int anyoConstruccion, String correoAtencion){}

    @Override
    public double calcularPrecioRealEntrada(int edad, boolean esFestivo) throws ExcepcionZooEntrada {
        boolean esGratis= false;
        double preciofinal= getPrecioEntrada();
        if (edad < 7){
            preciofinal = 0;
            esGratis = true;
        }else if (esFestivo){
            preciofinal *=1.30;
        }else {
            esGratis=false;
        }
        return preciofinal;
    }

    public List<Zoo> getServicios() {
        return servicios;
    }

    public void setServicios(List<Zoo> servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "servicios=" + servicios +
                '}';
    }
}
