package uy.edu.ort.aed2.obligatorio.Pasajeros.ListasCategorias;

import uy.edu.ort.aed2.obligatorio.Pasajeros.ArbolPasajero.Pasajero;

public class NodoPasajeroLista {
    private Pasajero dato;
    private NodoPasajeroLista sig;

    public NodoPasajeroLista(Pasajero dato) {
        this.dato = dato;
        this.sig = null;
    }

    public NodoPasajeroLista(Pasajero dato, NodoPasajeroLista sig) {
        this.dato = dato;
        this.sig = sig;
    }

    public Pasajero getDato() {
        return dato;
    }

    public void setDato(Pasajero dato) {
        this.dato = dato;
    }

    public NodoPasajeroLista getSig() {
        return sig;
    }

    public void setSig(NodoPasajeroLista sig) {
        this.sig = sig;
    }

    @Override
    public String toString() {
        return dato.toString();
    }
}
