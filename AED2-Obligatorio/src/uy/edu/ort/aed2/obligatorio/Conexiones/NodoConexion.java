package uy.edu.ort.aed2.obligatorio.Conexiones;

public class NodoConexion {
    private String OriginAirportCode;
    private String DestinationAirportCode;
    private Double km;
    private NodoConexion siguiente;
    private NodoConexion anterior;

    //private Connection right;
    //private Connection left;

    public NodoConexion(String originAirportCode, String destinationAirportCode, Double km) {
        this.OriginAirportCode = originAirportCode;
        this.DestinationAirportCode = destinationAirportCode;
        this.km = km;
    }

    public String getOriginAirportCode() {
        return OriginAirportCode;
    }

    public void setOriginAirportCode(String originAirportCode) {
        OriginAirportCode = originAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        DestinationAirportCode = destinationAirportCode;
    }

    public void setKm(Double km) {
        this.km = km;
    }

    public NodoConexion getSiguiente(){
        return this.siguiente;
    }
    public void setAnterior(NodoConexion nuevoNodo){
        this.anterior = nuevoNodo;
    }
    public void setSiguiente(NodoConexion nuevoNodo){
        this.siguiente = nuevoNodo;
    }

    public String getDestinationAirportCode() {
        return DestinationAirportCode;
    }

    public Double getKm() {
        return km;
    }


}
