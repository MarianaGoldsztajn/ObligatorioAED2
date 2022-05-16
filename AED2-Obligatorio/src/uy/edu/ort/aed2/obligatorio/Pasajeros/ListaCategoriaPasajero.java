package uy.edu.ort.aed2.obligatorio.Pasajeros;

import uy.edu.ort.aed2.obligatorio.Pasajeros.Enum.CategoriaPasajero;
import uy.edu.ort.aed2.obligatorio.Sistema;

public class ListaCategoriaPasajero {

    NodoCategoriaPasajero primero;
    NodoCategoriaPasajero ultimo;
    int cantidad;


    public NodoCategoriaPasajero getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoCategoriaPasajero ultimo) {
        this.ultimo = ultimo;
    }
    public ListaCategoriaPasajero() {
        this.primero = null;
        this.cantidad = 0;
        this.ultimo = null;
    }

    public NodoCategoriaPasajero getPrimero() {
        return primero;
    }

    public void setPrimero(NodoCategoriaPasajero primero) {
        this.primero = primero;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean esVacia() {
        if(primero == null){
            return true;
        }
        return false;
    }

    public String getInfoDeCategoria(CategoriaPasajero categoria){
        NodoCategoriaPasajero aux = this.primero;
        if(aux.getCategoria() == categoria){
            return aux.getDatosPasajeros();
        }
        while(aux.getSiguiente() != null){
            aux = aux.getSiguiente();
            if(aux.getCategoria() == categoria) {
                return aux.getDatosPasajeros();
            }
        }
        return "No se encuentran pasajeros registrados bajo esa categoría.";
    }



    public void agregarDatosAcategoria(NodoCategoriaPasajero nodo, NodoPasajero pasajero){
        String datosActuales = nodo.getDatosPasajeros();
        String datosActualizados = datosActuales + "|" + pasajero.getInfoPasajero();
        nodo.setDatosPasajeros(datosActualizados);
    }

    public void agregar(CategoriaPasajero categoria, NodoPasajero pasajero){
        NodoCategoriaPasajero aux = encontrarCategoria(categoria);
        if(aux == null){
            agregarinicio(categoria, pasajero.getInfoPasajero());
        }else{
            agregarDatosAcategoria(aux, pasajero);
        }
    }

    public NodoCategoriaPasajero encontrarCategoria(CategoriaPasajero categoria){
        if(!this.esVacia()){
            NodoCategoriaPasajero aux = this.getPrimero();
            while(aux.getSiguiente() != null){
                if(aux.getCategoria().equals(categoria)){
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }


    public void agregarinicio(CategoriaPasajero categoria, String datosPasajero) {
        NodoCategoriaPasajero nuevoNodo = new NodoCategoriaPasajero(categoria, datosPasajero);
        if (!this.esVacia()) {
            nuevoNodo.setSiguiente(this.primero);
        } else {
            this.setUltimo(nuevoNodo);
        }
        this.setPrimero(nuevoNodo);
        this.cantidad = this.cantidad + 1;
    }

    public void agregarfinal(CategoriaPasajero categoria, String ids) {
        NodoCategoriaPasajero nuevoNodo = new NodoCategoriaPasajero(categoria, ids);
        if(this.esVacia()){
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
        }else{
            NodoCategoriaPasajero aux = this.getPrimero();
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevoNodo);
        }
        this.cantidad ++;
    }

    //    @Override
    //    public Retorno borrarinicio() {
    //        Retorno ret = new Retorno(Retorno.Resultado.OK);
    //        ret.valorbooleano = false;
    //        if(!this.esVacia().valorbooleano){//Si no es vacia puedo borrar
    //            this.setPrimero(this.primero.getSiguiente());//Java lo elimina de la memoria
    //            //El primero deja de estar apuntado por alguien
    //            this.cantidad --;
    //            ret.valorbooleano = true;
    //        }//Podria poner un else y un string "Elemento borrado".
    //        return ret;
    //    }
    //
    //    @Override
    //    public Retorno borrarfinal() {
    //        Retorno ret = new Retorno(Retorno.Resultado.OK);
    //        nodo aux = this.getPrimero();
    //        if(!this.esVacia().valorbooleano){
    //            if(this.cantidad == 1){
    //                this.primero = null;
    //            }else{
    //                while(aux.siguiente.siguiente != null){
    //                    aux = aux.siguiente;
    //                }
    //                aux.setSiguiente(null);
    //            }
    //
    //        }
    //        return ret;
    //    }
    //
    //    @Override
    //    public Retorno buscarelemento(int x) {
    //        Retorno ret = new Retorno(Retorno.Resultado.OK);
    //
    //        return ret;
    //    }
    //
    //    @Override
    //    public Retorno buscarelemento2(int x) {
    //        Retorno ret = new Retorno(Retorno.Resultado.OK);
    //
    //        return ret;
    //    }
    //
    //    @Override
    //    public Retorno eliminarelemento(int x) {
    //        Retorno ret = new Retorno(Retorno.Resultado.OK);
    //
    //        return ret;}
    //
    //    @Override
    //    public Retorno mostrarlista() {
    //        Retorno ret = new Retorno(Retorno.Resultado.OK);
    //        ret.valorString = "";
    //        if(!this.esVacia().valorbooleano){
    //            //Precios un auxiliar
    //            nodo aux = this.getPrimero();
    //            while (aux != null){
    //                ret.valorString = ret.valorString + aux.getDato() + " - ";
    //                aux = aux.getSiguiente();
    //            }
    //
    //        }
    //        return ret;}

}