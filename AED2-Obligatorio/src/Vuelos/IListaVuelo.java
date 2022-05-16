package Vuelos;

public interface IListaVuelo {
    public boolean esVacia();
    public void agregarFinal(String codigoAeropuertoOrigen, String codigoAeropuertoDestino,String codigoDeVuelo, double combustible, double minutos, double costoEnDolares);
    public void agregarInicio(String codigoAeropuertoOrigen, String codigoAeropuertoDestino,String codigoDeVuelo, double combustible, double minutos, double costoEnDolares);
    public boolean buscarelemento(String codigoDeVuelo);
    public NodoVuelo obtenerelemento(String codigoDeVuelo);
    public void agregarOrdenado(String codigoAeropuertoOrigen, String codigoAeropuertoDestino,String codigoDeVuelo, double combustible, double minutos, double costoEnDolares);

}