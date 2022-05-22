package uy.edu.ort.aed2.obligatorio.Pasajeros;

import uy.edu.ort.aed2.obligatorio.Pasajeros.ArbolPasajero.NodoPasajero;
import uy.edu.ort.aed2.obligatorio.Pasajeros.ArbolPasajero.Pasajero;
import uy.edu.ort.aed2.obligatorio.Pasajeros.ArbolPasajero.PasajeroABB;
import uy.edu.ort.aed2.obligatorio.Pasajeros.Enum.CategoriaPasajero;
import uy.edu.ort.aed2.obligatorio.Pasajeros.ListasCategorias.ControlCategoriasPasajeros;
import uy.edu.ort.aed2.obligatorio.Retorno;

public class ControlPasajero {
    PasajeroABB arbol;
    ControlCategoriasPasajeros listaCat;

    public ControlPasajero() {
        this.arbol = new PasajeroABB();
        this.listaCat = new ControlCategoriasPasajeros();
    }

    public String encontrarPasajero(String id){
        return this.arbol.encontrarPasajero(id);
    }

    public String listarAscendente(){
        return this.arbol.listarAscendente();
    }
    public String listarDescendente(){
        return this.arbol.listarDescendente();
    }
    public Retorno agregarPasajero(String id, String nombre, String telefono, CategoriaPasajero categoria){
        Pasajero pas = new Pasajero(id, nombre, telefono, categoria);
        NodoPasajero pasajero = new NodoPasajero(pas);
        Retorno ret = this.arbol.agregarPasajero(pasajero);
        if(ret.resultado == Retorno.Resultado.OK){
            this.listaCat.getPasajerosDeLista(pas.getCategoria()).insertar(pas);
        }
        return ret;
    }

    public String getIdsPorCategoria(CategoriaPasajero categoria){
        //this.listaCat.getPasajerosDeLista(categoria).getClass();
        return "";
    }

}
