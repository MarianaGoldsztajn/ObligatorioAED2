package uy.edu.ort.aed2.obligatorio.Pasajeros;

import uy.edu.ort.aed2.obligatorio.Pasajeros.Enum.CategoriaPasajero;

public class NodoCategoriaPasajero {
    private CategoriaPasajero categoria;
    private String datosPasajeros;
    private NodoCategoriaPasajero siguiente;

    public NodoCategoriaPasajero(CategoriaPasajero categoria, String id) {
        this.categoria = categoria;
        this.datosPasajeros = id;
        this.siguiente = null;
    }

    public CategoriaPasajero getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPasajero categoria) {
        this.categoria = categoria;
    }

    public String getDatosPasajeros() {
        return datosPasajeros;
    }

    public void setDatosPasajeros(String datosPasajeros) {
        this.datosPasajeros = datosPasajeros;
    }

    public NodoCategoriaPasajero getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCategoriaPasajero siguiente) {
        this.siguiente = siguiente;
    }
}
