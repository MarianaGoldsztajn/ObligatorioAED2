package Vuelos;

import Vuelos.NodoVuelo;

public class ListaVuelos implements IListaVuelo{
    NodoVuelo primero;
    NodoVuelo ultimo;
    int cantidad;

    public ListaVuelos() {
        this.primero = null;
        this.ultimo = null;
        this.cantidad = 0;
    }

    public NodoVuelo getPrimero() {return primero;}

    public void setPrimero(NodoVuelo primero) {this.primero = primero;}

    public NodoVuelo getUltimo() {return ultimo;}

    public void setUltimo(NodoVuelo ultimo) {this.ultimo = ultimo;}

    public int getCantidad() {return cantidad;}


    @Override
    public boolean esVacia() {
        return this.getCantidad() == 0;
    }

    @Override
    public void agregarInicio(String codigoAeropuertoOrigen, String codigoAeropuertoDestino,String codigoDeVuelo, double combustible, double minutos, double costoEnDolares) {
        NodoVuelo nuevo = new NodoVuelo(codigoAeropuertoOrigen, codigoAeropuertoDestino,  codigoDeVuelo,  combustible,  minutos, costoEnDolares);
        if (this.esVacia()) {
            this.setPrimero(nuevo);
            this.setUltimo(nuevo);
        } else {
            nuevo.setSiguiente(this.getPrimero());
            this.getPrimero().setAnterior(nuevo);
            this.setPrimero(nuevo);
        }
        this.cantidad++;
    }

    @Override
    public void agregarFinal(String codigoAeropuertoOrigen, String codigoAeropuertoDestino,String codigoDeVuelo, double combustible, double minutos, double costoEnDolares) {
        NodoVuelo nuevo = new NodoVuelo(codigoAeropuertoOrigen, codigoAeropuertoDestino,  codigoDeVuelo,  combustible,  minutos, costoEnDolares);
        if (this.esVacia()) {
            this.setPrimero(nuevo);
            this.setUltimo(nuevo);
        } else {
            this.ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(this.ultimo);
            this.setUltimo(nuevo);
        }
        this.cantidad++;
    }

    @Override
    public boolean buscarelemento(String codigoDeVuelo) {
        NodoVuelo aux = this.getPrimero();
        if (this.primero.getCodigoDeVuelo() == codigoDeVuelo || this.ultimo.getCodigoDeVuelo() == codigoDeVuelo) {
            return true;
        }
        while (aux != null && aux.getCodigoDeVuelo() != codigoDeVuelo) {
            aux = aux.getSiguiente();
        }
        if (aux == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public NodoVuelo obtenerelemento(String codigoDeVuelo) {
        NodoVuelo aux = this.getPrimero();
        while (aux != null && aux.getCodigoDeVuelo() != codigoDeVuelo) {
            aux = aux.getSiguiente();
        }
        return aux;
    }

    // a esta altura ya se sabe que conexion existe
    @Override
    public void agregarOrdenado(String codigoAeropuertoOrigen, String codigoAeropuertoDestino,String codigoDeVuelo, double combustible, double minutos, double costoEnDolares) {

        if(!this.buscarelemento(codigoDeVuelo)){
            if (this.esVacia() || costoEnDolares<this.getPrimero().getCostoEnDolares()){
                this.agregarInicio( codigoAeropuertoOrigen, codigoAeropuertoDestino,  codigoDeVuelo,  combustible,  minutos, costoEnDolares);
            }else{
                if (costoEnDolares > this.getUltimo().getCostoEnDolares()){
                    this.agregarFinal(codigoAeropuertoOrigen, codigoAeropuertoDestino,  codigoDeVuelo,  combustible,  minutos, costoEnDolares);
                }else{
                    NodoVuelo aux= this.getPrimero();
                    NodoVuelo nuevo = new NodoVuelo(codigoAeropuertoOrigen, codigoAeropuertoDestino,  codigoDeVuelo,  combustible,  minutos, costoEnDolares);
                    while (aux!=null && costoEnDolares > aux.getCostoEnDolares()){
                        aux=aux.getSiguiente();
                    }
                    nuevo.setSiguiente(aux);
                    nuevo.setAnterior(aux.getAnterior());
                    aux.setAnterior(nuevo);
                    nuevo.getAnterior().setSiguiente(nuevo);
                    this.cantidad++;
                }
            }
        }


    }

    public void actualizarVuelo(String codigoAeropuertoOrigen, String codigoAeropuertoDestino,String codigoDeVuelo, double combustible, double minutos, double costoEnDolares){
        NodoVuelo vueloActualizado = this.obtenerelemento(codigoDeVuelo);
        vueloActualizado.setCodigoAeropuertoOrigen(codigoAeropuertoOrigen);
        vueloActualizado.setCodigoAeropuertoDestino(codigoAeropuertoDestino);
        vueloActualizado.setCombustible(combustible);
        vueloActualizado.setMinutos(minutos);
        vueloActualizado.setCostoEnDolares(costoEnDolares);

    }

}