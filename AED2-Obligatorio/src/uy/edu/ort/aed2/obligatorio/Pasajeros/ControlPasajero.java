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
        return this.arbol.findPassenger(id);
    }

    public String listarAscendente(){
        return this.arbol.listAscending();
    }
    public String listarDescendente(){
        return this.arbol.listDescending();
    }
    public Retorno agregarPasajero(String id, String name, String phone, CategoriaPasajero category){
        Retorno ret = this.arbol.addPassenger(id,name,phone,category);
        if(ret.resultado == Retorno.Resultado.OK){
            this.listaCat.agregar(category, id);
        }
        return ret;
    }

    public String getIdsPorCategoria(CategoriaPasajero categoria){
        return this.listaCat.getIdsCategoria(categoria);
    }

}
