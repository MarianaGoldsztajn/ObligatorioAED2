package uy.edu.ort.aed2.obligatorio.Conexiones;

import uy.edu.ort.aed2.obligatorio.Aeropuertos.AeropuertoABB;
import uy.edu.ort.aed2.obligatorio.Retorno;

import java.util.Hashtable;

public class ConexionMgr {
    //Se me ocurre hacer algo similar a un diccionario, donde hay una key origenes y el value es una lista de conexiones
    //Podriamos tener una lista de origenes y que cada nodo de esa lista apunte aparte a una lista de conexiones con
    //ese origen. Entonces, cuando pide ejemplo un origen con 1 conexion se recorre la primer lista y cuando se encuentra ese origen
    //se devuelve la lista que tiene asociada (interesarian solamente los destinos de cada nodo), si piden 2 escalas, habria que repetir lo anterior y para cada nodo de la primer recorrida
    //buscar la lista asociada a su destino.

    //Lo implemente con un dicc para probar, pero habria que cambiarlo a una lista si es que esta bien.



    public Hashtable<String, ListaConexion> passCategory = new Hashtable<String, ListaConexion>();

    public Retorno agregarConexion(String originAirportCode, String destinationAirportCode, Double km){
        Retorno ret;
        if(passCategory.containsKey(originAirportCode)){
            ListaConexion conexiones = passCategory.get(originAirportCode);
            ret = conexiones.agregarInicio(originAirportCode, destinationAirportCode, km);
            passCategory.replace(originAirportCode, conexiones);
        }else{
            ListaConexion newList = new ListaConexion();
            ret = newList.agregarInicio(originAirportCode, destinationAirportCode, km);
            passCategory.put(originAirportCode, newList);
        }
        return ret;
    }




}
