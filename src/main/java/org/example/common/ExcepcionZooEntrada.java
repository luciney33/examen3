package org.example.common;

public class ExcepcionZooEntrada extends RuntimeException {
    public ExcepcionZooEntrada() {
        super("El precio esta entre 10 y 20 euros");
    }
    public ExcepcionZooEntrada(String msg){
        super(msg);
    }
}
