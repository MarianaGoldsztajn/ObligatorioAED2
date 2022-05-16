package uy.edu.ort.aed2.obligatorio.Aeropuertos;

import uy.edu.ort.aed2.obligatorio.Retorno;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GrafoAeropuerto {
    private Aeropuerto[] aeropuertos;
    private Conexion[][] aristasConexiones;
    private int maximoAeropuertos;

    public GrafoAeropuerto(int unTope) {
        aeropuertos = new Aeropuerto[unTope];
        maximoAeropuertos = unTope;
        aristasConexiones = new Conexion[unTope][unTope];
    }

    public boolean esLleno() {
        if(maximoAeropuertos == aeropuertos.length){
            return true;
        }
        return false;
    }

    public boolean esVacio() {
        if(aeropuertos.length == 0){
            return true;
        }
        return false;
    }

    // PRE: !esLleno()
    private int obtenerPosLibre() {
        int largo = aeropuertos.length;
        if(esVacio()){
            return largo;
        }else{
            return largo++;
        }
    }
    //POS: Si no existe el vector se devolvera -1
    private int obtenerPos(Aeropuerto aeropuerto) {
        int largo = aeropuertos.length;
        for (int i = 0; i < largo ; i++){
            if(aeropuertos[i].equals(aeropuerto)){
                return i;
            }
        }
        return -1;
    }

    // PRE: !esLleno && !existeVertice
    public Retorno agregarAeropuerto(Aeropuerto aeropuerto) {
        int cantAeropuerto = aeropuertos.length;
        if(cantAeropuerto == maximoAeropuertos){
            return new Retorno(Retorno.Resultado.ERROR_1);
        }else{
            if(!Aeropuerto.datosValidos(aeropuerto)){
                return new Retorno(Retorno.Resultado.ERROR_2);
            }else{
                if(existeAeropuerto(aeropuerto)){
                    return new Retorno(Retorno.Resultado.ERROR_3);
                }
            }
        }
        aeropuertos[obtenerPosLibre()] = aeropuerto;
        return new Retorno(Retorno.Resultado.OK);
    }

    // PRE: existeVertice
    public void borrarAeropuerto(Aeropuerto aeropuerto) {
        int pos = obtenerPos(aeropuerto);
        int largo = aeropuertos.length;
        for (int i = 0; i < largo ; i++){
            aristasConexiones[pos][i] = null;
            aristasConexiones[i][pos] = null;
        }
        aeropuertos[pos] = null;
    }

    public boolean existeAeropuerto(Aeropuerto aeropuerto) {
        int largo = aeropuertos.length;
        for (int i = 0; i < largo ; i++){
            if(aeropuertos[i].equals(aeropuerto)){
                return true;
            }
        }
        return false;
    }

    // existeVertice(origen) && existeVertice(destino) && !existeArista
    public Retorno agregarConexion(Aeropuerto origen, Aeropuerto destino, double km) {
        if(!Conexion.KmValidos(km)) {
            return new Retorno(Retorno.Resultado.ERROR_1);
        } else if(!existeAeropuerto(origen)){
            return new Retorno(Retorno.Resultado.ERROR_2);
        }else if(!existeAeropuerto(destino)){
            return new Retorno(Retorno.Resultado.ERROR_3);
        }
        int posOrigen = obtenerPos(origen);
        int posDestino = obtenerPos(destino);
        Conexion nuevaConexion = new Conexion(km);
        aristasConexiones[posOrigen][posDestino] = nuevaConexion;
        return new Retorno(Retorno.Resultado.OK);

    }

    // existeVertice(origen) && existeVertice(destino)
    public boolean existeArista(Aeropuerto origen, Aeropuerto destino) {
        int posOrigen = obtenerPos(origen);
        int posDestino = obtenerPos(destino);
        if(aristasConexiones[posOrigen][posDestino] != null){
            return true;
        }
        return false;
    }

    // existeVertice(origen) && existeVertice(destino) && existeArista
    public void borrarConexion(Aeropuerto origen, Aeropuerto destino) {
        int posOrigen = obtenerPos(origen);
        int posDestino = obtenerPos(destino);
        aristasConexiones[posOrigen][posDestino] = null;
    }

    public Retorno listadoAeropuertosCantDeEscalas(String codigoAeropuertoDeOrigen, int cantidad){
        ColaImp cola = new ColaImp();
        ArrayList<String> visitados = new ArrayList<>();
        visitados.add(vert);
        cola.encolar(vert);
        while(!cola.esVacia()){
            String vertCola = cola.desencolar();
            System.out.println(vertCola);
            Lista<String> verticesAdy = verticesAdyacentes(vertCola);
            for(String ady: verticesAdy){
                if(!visitados.contains(ady)){
                    visitados.add(ady);
                    cola.encolar(ady);
                }
            }
        }
    }




}
