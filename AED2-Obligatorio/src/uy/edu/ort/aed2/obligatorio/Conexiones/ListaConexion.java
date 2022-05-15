package uy.edu.ort.aed2.obligatorio.Conexiones;

import uy.edu.ort.aed2.obligatorio.Aeropuertos.AeropuertoABB;
import uy.edu.ort.aed2.obligatorio.Retorno;

public class ListaConexion {
    NodoConexion primero;
    NodoConexion ultimo;
    int cantidad;

    public ListaConexion() {
        this.primero = null;
        this.ultimo = null;
        this.cantidad = 0;
    }

    public NodoConexion getPrimero() {
        return primero;
    }

    public void setPrimero(NodoConexion primero) {
        this.primero = primero;
    }

    public NodoConexion getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoConexion ultimo) {
        this.ultimo = ultimo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public NodoConexion obtenerelemento(String originAirportCode, String destinationAirportCode) {
        NodoConexion aux = this.getPrimero();
        while (aux != null) {
            if (aux.getOriginAirportCode() == originAirportCode && aux.getOriginAirportCode() == destinationAirportCode) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return aux;
    }
    public Retorno validarData(String originAirportCode, String destinationAirportCode, Double km){
        if(km <= 0){
            return new Retorno(Retorno.Resultado.ERROR_1);
        }else if(verificarAeropuertoExistente(originAirportCode).resultado != Retorno.Resultado.OK){
            return new Retorno(Retorno.Resultado.ERROR_2);
        }else if(verificarAeropuertoExistente(originAirportCode).resultado != Retorno.Resultado.OK){
            return new Retorno(Retorno.Resultado.ERROR_3);
        }
        return new Retorno(Retorno.Resultado.OK);
    }

    public Retorno verificarAeropuertoExistente(String airportCode){
        AeropuertoABB airportsABB = new AeropuertoABB();
        return airportsABB.checkExistingAirport(airportCode);
    }

    public Retorno agregarInicio(String originAirportCode, String destinationAirportCode, Double km) {
        Retorno ret = validarData(originAirportCode, destinationAirportCode, km);
        if(ret.resultado == Retorno.Resultado.OK){
            NodoConexion nuevo = new NodoConexion(originAirportCode, destinationAirportCode, km);
            if (obtenerelemento(originAirportCode, destinationAirportCode) == null){
                if (this.esVacia()) {
                    this.setPrimero(nuevo);
                    this.setUltimo(nuevo);
                } else {
                    this.getPrimero().setAnterior(nuevo);
                    nuevo.setSiguiente(this.getPrimero());
                    nuevo.setAnterior(null);
                    this.setPrimero(nuevo);
                }
                this.cantidad = this.cantidad + 1;
            }
            return new Retorno(Retorno.Resultado.ERROR_4);
        }
        return ret;
    }

    public boolean esVacia(){
        return this.cantidad == 0;
    }



}
