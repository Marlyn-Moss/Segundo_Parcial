package com.pandora.n.ejercicionivelacion;

public class Puntaje {
    public String jugador;
    public int puntaje;

    public Puntaje(String jugador, int puntaje) {
        this.jugador = jugador;
        this.puntaje = puntaje;
    }
    public String getString(){
        return this.jugador+"  "+this.puntaje;
    }
}
