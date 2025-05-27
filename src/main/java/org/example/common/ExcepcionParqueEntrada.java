package org.example.common;

public class ExcepcionParqueEntrada extends RuntimeException {
    public ExcepcionParqueEntrada() {
        super("El precio esta entre 15 y 20 euros");
    }
    public ExcepcionParqueEntrada(String msg){
        super(msg);
    }
}
