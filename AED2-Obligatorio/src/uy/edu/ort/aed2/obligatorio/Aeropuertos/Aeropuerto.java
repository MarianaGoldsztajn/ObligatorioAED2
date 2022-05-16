package uy.edu.ort.aed2.obligatorio.Aeropuertos;

import uy.edu.ort.aed2.obligatorio.Retorno;

public class Aeropuerto {
    private String Codigo;
    private String Nombre;

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Aeropuerto(String codigo, String nombre) {
        codigo = codigo;
        Nombre = nombre;
    }

    public static boolean datosValidos(Aeropuerto aeropuerto){
        String codigo = aeropuerto.getCodigo();
        String nombre = aeropuerto.getNombre();
        return !(codigo.isEmpty() || codigo.isBlank()|| nombre.isBlank() || nombre.isEmpty());
    }
}
