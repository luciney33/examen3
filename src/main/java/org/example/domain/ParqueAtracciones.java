package org.example.domain;

import org.example.common.ExcepcionParqueEntrada;

import java.util.List;

public class ParqueAtracciones extends CentroOcio{
    private int edadMin;

    public ParqueAtracciones(int anyoConstruccion, String correoAtencion, int id, String nombre, double precioEntrada,
                             String provincia, List<Integer> valoraciones,int edadMin) {
        super(anyoConstruccion, correoAtencion, id, nombre, precioEntrada, provincia, valoraciones);
        this.edadMin=edadMin;
    }
    public ParqueAtracciones(int id, String nombre, double precioEntrada, String provincia, int anyoConstruccion, String correoAtencion, List<Integer> valoraciones, int edadMin){}

    public int getEdadMin() {
        return edadMin;
    }

    public void setEdadMin(int edadMin) {
        this.edadMin = edadMin;
    }

    @Override
    public double calcularPrecioRealEntrada(int edad, boolean esFestivo) throws ExcepcionParqueEntrada {
        boolean esGratis = false;
        double preciofinal = getPrecioEntrada();
        if (edad > 65) {
            preciofinal = 0;
            esGratis = true;
        }else if (esFestivo){
            preciofinal *=1.40;
        }else{
            esGratis=false;
        }

        return preciofinal;
    }

    @Override
    public String toString() {
        return "ParqueAtracciones{" +
                "edadMin=" + edadMin +
                '}';
    }
}
