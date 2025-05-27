package org.example.common;

public class ExcepcionValoraciones extends RuntimeException {
    public ExcepcionValoraciones() {

      super("El valor 1 entre 5");
    }
    public ExcepcionValoraciones(String msg){
      super(msg);
    }
}
