package uy.edu.ort.aed2.obligatorio.Pasajeros;

import uy.edu.ort.aed2.obligatorio.Pasajeros.Enum.CategoriaPasajero;
import uy.edu.ort.aed2.obligatorio.Retorno;

public class ControlPasajero {
    PasajeroABB arbol;
    ListaCategoriaPasajero listaCat;

    public ControlPasajero() {
        this.arbol = new PasajeroABB();
        this.listaCat = new ListaCategoriaPasajero();
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
        NodoPasajero pasajero = new NodoPasajero(id, nombre, telefono, categoria);
        Retorno ret = this.arbol.agregarPasajero(pasajero);
        if(ret.resultado == Retorno.Resultado.OK){
            this.listaCat.agregar(categoria, pasajero);
        }
        return ret;
    }

    public String getIdsPorCategoria(CategoriaPasajero categoria){
        return this.listaCat.getInfoDeCategoria(categoria);
    }

}
