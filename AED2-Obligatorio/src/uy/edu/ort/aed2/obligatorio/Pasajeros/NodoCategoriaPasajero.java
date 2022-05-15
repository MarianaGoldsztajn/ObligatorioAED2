package uy.edu.ort.aed2.obligatorio.Pasajeros;

import uy.edu.ort.aed2.obligatorio.Pasajeros.Enum.CategoriaPasajero;

public class NodoCategoriaPasajero {
    private CategoriaPasajero categoria;
    private String ids;
    private NodoCategoriaPasajero siguiente;

    public NodoCategoriaPasajero(CategoriaPasajero categoria, String id) {
        this.categoria = categoria;
        this.ids = id;
        this.siguiente = null;
    }

    public CategoriaPasajero getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPasajero categoria) {
        this.categoria = categoria;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public void setSiguiente(NodoCategoriaPasajero siguiente) {
        this.siguiente = siguiente;
    }
    public NodoCategoriaPasajero getSiguiente() {
       return this.siguiente;
    }

}
