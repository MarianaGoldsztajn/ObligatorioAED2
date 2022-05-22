package uy.edu.ort.aed2.obligatorio.Pasajeros.ArbolPasajero;

import uy.edu.ort.aed2.obligatorio.Pasajeros.ControlPasajero;
import uy.edu.ort.aed2.obligatorio.Retorno;

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

    public static boolean pasajeroExistenteRecursivo(NodoPasajero pasajero, String id){
        if(pasajero == null) {
            return false;
        }else if(pasajero.getPasajero().getId() == id) {
            return true;
        }else {
            return pasajeroExistenteRecursivo(pasajero.getIzquierda(), id) || pasajeroExistenteRecursivo(pasajero.getDerecha(), id);
        }
    }

    public Retorno agregarPasajero(NodoPasajero pasajero){
        if(!Pasajero.datosValidos(pasajero.getPasajero())){
            return new Retorno(Retorno.Resultado.ERROR_1);
        }else{
            Retorno retValidPassengerId = Pasajero.validarId(pasajero.getPasajero().getId());
            Retorno retExistingPassenger = pasajeroExistente(pasajero.getPasajero().getId());
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
    private void guardarRecursivo(NodoPasajero pasajero, NodoPasajero nuevoPasajero) {
        if (pasajero.getPasajero().getIdNumerico() > nuevoPasajero.getPasajero().getIdNumerico()) {
            if (pasajero.getDerecha() == null) {
                pasajero.setDerecha(nuevoPasajero);
            } else {
                guardarRecursivo(pasajero.getDerecha(), nuevoPasajero);
            }
        } else {
            if (pasajero.getIzquierda() == null) {
                pasajero.setIzquierda(nuevoPasajero);
            } else {
                guardarRecursivo(pasajero.getIzquierda(), nuevoPasajero);
            }
        }
    }

    public String encontrarPasajero(String id) {
        NodoPasajero pasajero = encontrarPasajeroRecursivo(this.raiz, id);
        if( pasajero != null){
            return pasajero.getPasajero().getInfoPasajero();
        }else{
            return "The passenger was not found in the system.";
        }
    }
    public String listarAscendente(){
        if(this.raiz == null){
            return "There are no passengers in the system.";
        }else if(this.raiz.isLeaf()){
            return this.raiz.getPasajero().getInfoPasajero();
        }else {
            String text = listarAscendenteRecursivo(this.raiz, "");
            return text;
        }
    }

    public String listarAscendenteRecursivo(NodoPasajero passenger, String text) {
        if(passenger != null) {
            text = listarAscendenteRecursivo(passenger.getDerecha(), text);
            text += passenger.getPasajero().getInfoPasajero() + "|";
            text = listarAscendenteRecursivo(passenger.getIzquierda(), text);
        }
        return text;
    }
    public String listarDescendente(){
        if(this.raiz == null){
            return "There are no passengers in the system.";
        }else if(this.raiz.isLeaf()){
            return this.raiz.getPasajero().getInfoPasajero();
        }else {
            return listarDescendenteRecursivo(this.raiz, "");
        }
    }

    private String listarDescendenteRecursivo(NodoPasajero passenger, String text) {
        if(passenger != null) {
            text = listarDescendenteRecursivo(passenger.getIzquierda(), text);
            text += passenger.getPasajero().getInfoPasajero() + "|";
            text = listarDescendenteRecursivo(passenger.getDerecha(), text);
        }
        return text;
    }

    public static NodoPasajero encontrarPasajeroRecursivo(NodoPasajero passenger, String id){
        if(passenger == null) {
            return null;
        }else if(passenger.getPasajero().getNombre() == id) {
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
