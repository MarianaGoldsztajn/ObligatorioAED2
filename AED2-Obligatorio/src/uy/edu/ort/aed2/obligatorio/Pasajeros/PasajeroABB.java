package uy.edu.ort.aed2.obligatorio.Pasajeros;

import uy.edu.ort.aed2.obligatorio.Pasajeros.Enum.CategoriaPasajero;
import uy.edu.ort.aed2.obligatorio.Retorno;
import uy.edu.ort.aed2.obligatorio.Utils;

public class PasajeroABB {
    private NodoPasajero raiz;
    private ControlPasajero pc;

    public PasajeroABB(){
        pc = new ControlPasajero();
    }


    public Retorno pasajeroExistente(String id) {
        if(pasajeroExistenteRecursivo(this.raiz, id)){
            return new Retorno(Retorno.Resultado.ERROR_3);
        }else{
            return new Retorno(Retorno.Resultado.OK);
        }
    }

    public static boolean pasajeroExistenteRecursivo(NodoPasajero passenger, String id){
        if(passenger == null) {
            return false;
        }else if(passenger.getId() == id) {
            return true;
        }else {
            return pasajeroExistenteRecursivo(passenger.getIzquierda(), id) || pasajeroExistenteRecursivo(passenger.getDerecha(), id);
        }
    }

    public Retorno agregarPasajero(NodoPasajero pasajero){
        if(!NodoPasajero.datosValidos(pasajero)){
            return new Retorno(Retorno.Resultado.ERROR_1);
        }else{
            Retorno retValidPassengerId = NodoPasajero.validarId(pasajero.getId());
            Retorno retExistingPassenger = pasajeroExistente(pasajero.getId());
            if(retValidPassengerId.resultado.equals(Retorno.Resultado.OK)){
                if(retExistingPassenger.resultado.equals(Retorno.Resultado.OK)){
                    guardar(pasajero);
                    return new Retorno(Retorno.Resultado.OK);
                }else{
                    return retExistingPassenger;
                }
            }else{
                return retValidPassengerId;
            }
        }
    }

    public void guardar(NodoPasajero newPassenger) {
        if (raiz == null) {
            raiz = newPassenger;
        } else {
            guardarRecursivo(raiz, newPassenger);
        }
    }
    private void guardarRecursivo(NodoPasajero passenger, NodoPasajero newPassenger) {
        if (passenger.getIdNumerico() > newPassenger.getIdNumerico()) {
            if (passenger.getDerecha() == null) {
                passenger.setDerecha(newPassenger);
            } else {
                guardarRecursivo(passenger.getDerecha(), newPassenger);
            }
        } else {
            if (passenger.getIzquierda() == null) {
                passenger.setIzquierda(newPassenger);
            } else {
                guardarRecursivo(passenger.getIzquierda(), newPassenger);
            }
        }
    }

    public String encontrarPasajero(String id) {
        NodoPasajero passenger = encontrarPasajeroRecursivo(this.raiz, id);
        if( passenger != null){
            return passenger.getInfoPasajero();
        }else{
            return "The passenger was not found in the system.";
        }
    }
    public String listarAscendente(){
        if(this.raiz == null){
            return "There are no passengers in the system.";
        }else if(this.raiz.isLeaf()){
            return this.raiz.getInfoPasajero();
        }else {
            String text = listarAscendenteRecursivo(this.raiz, "");
            return text;
        }
    }

    public String listarAscendenteRecursivo(NodoPasajero passenger, String text) {
        if(passenger != null) {
            text = listarAscendenteRecursivo(passenger.getDerecha(), text);
            text += passenger.getInfoPasajero() + "|";
            text = listarAscendenteRecursivo(passenger.getIzquierda(), text);
        }
        return text;
    }
    public String listarDescendente(){
        if(this.raiz == null){
            return "There are no passengers in the system.";
        }else if(this.raiz.isLeaf()){
            return this.raiz.getInfoPasajero();
        }else {
            return listarDescendenteRecursivo(this.raiz, "");
        }
    }

    private String listarDescendenteRecursivo(NodoPasajero passenger, String text) {
        if(passenger != null) {
            text = listarDescendenteRecursivo(passenger.getIzquierda(), text);
            text += passenger.getInfoPasajero() + "|";
            text = listarDescendenteRecursivo(passenger.getDerecha(), text);
        }
        return text;
    }

    public static NodoPasajero encontrarPasajeroRecursivo(NodoPasajero passenger, String id){
        if(passenger == null) {
            return null;
        }else if(passenger.getNombre() == id) {
            return passenger;
        }else {
            NodoPasajero passenger1 = encontrarPasajeroRecursivo(passenger.getIzquierda(), id);
            NodoPasajero passenger2 = encontrarPasajeroRecursivo(passenger.getDerecha(), id);
            if(passenger1 != null){
                return passenger1;
            }else if(passenger2 != null){
                return passenger2;
            }else{
                return null;
            }
        }
    }

    //Falta listar por categoria //Guardar un arbol aparte por categoria?

}
