package uy.edu.ort.aed2.obligatorio.Pasajeros.ListasCategorias;

import uy.edu.ort.aed2.obligatorio.Generico.Lista;
import uy.edu.ort.aed2.obligatorio.Pasajeros.ArbolPasajero.Pasajero;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public abstract class ListaCategoriaPasajero implements Lista {
    protected NodoPasajeroLista inicio;
    protected int largo;

    public ListaCategoriaPasajero() {
        this.inicio = null;
        this.largo = 0;
    }

    @Override
    public void insertar(Object dato) {
        inicio = new NodoPasajeroLista((Pasajero) dato, inicio);
        largo++;
    }


    @Override
    public int largo() {
        return largo;
    }

    @Override
    public boolean esVacia() {
        return largo == 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        Lista.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Lista.super.spliterator();
    }

    public String getInfoDeTodosLosPasajeros(){
        String text = "";
        if(!this.esVacia()){
            var aux = this.inicio;
            while(aux != null){
                text += aux.getDato().getInfoPasajero() + " | ";
            }
        }
        return text;
    }
}
