package uy.edu.ort.aed2.obligatorio.Aeropuertos;

import uy.edu.ort.aed2.obligatorio.Retorno;

public class Conexion {
    private boolean existe;
    private Double km;


    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
    }

    public Conexion(Double km) {
        this.existe = true;
        this.km = km;
    }

    public static boolean KmValidos(double km){
        return !(km <= 0);

    }
}
