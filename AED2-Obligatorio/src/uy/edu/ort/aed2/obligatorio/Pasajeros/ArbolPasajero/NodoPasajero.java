package uy.edu.ort.aed2.obligatorio.Pasajeros.ArbolPasajero;

public class NodoPasajero {
    private Pasajero pasajero;
    private NodoPasajero Derecha;
    private NodoPasajero Izquierda;

    public NodoPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public NodoPasajero getDerecha() {
        return Derecha;
    }

    public void setDerecha(NodoPasajero derecha) {
        Derecha = derecha;
    }

    public NodoPasajero getIzquierda() {
        return Izquierda;
    }

    public void setIzquierda(NodoPasajero izquierda) {
        Izquierda = izquierda;
    }

    public boolean isLeaf() {
        return this.getIzquierda() == null && this.getDerecha() == null;
    }



}