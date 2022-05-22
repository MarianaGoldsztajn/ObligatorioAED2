package uy.edu.ort.aed2.obligatorio.Pasajeros.ListasCategorias;

import uy.edu.ort.aed2.obligatorio.Generico.Lista;
import uy.edu.ort.aed2.obligatorio.Pasajeros.Enum.CategoriaPasajero;

import static uy.edu.ort.aed2.obligatorio.Pasajeros.Enum.CategoriaPasajero.Esporadico;

public class ControlCategoriasPasajeros {
    ListaPasajerosEsporadico esporadico;
    ListaPasajerosEstandar estandar;
    ListaPasajerosFrecuente frecuente;
    ListaPasajerosNuevo nuevo;
    ListaPasajerosPlatino platino;

    public ControlCategoriasPasajeros() {
        this.esporadico = new ListaPasajerosEsporadico();
        this.estandar = new ListaPasajerosEstandar();
        this.frecuente = new ListaPasajerosFrecuente();
        this.nuevo = new ListaPasajerosNuevo();
        this.platino = new ListaPasajerosPlatino();
    }

    public Lista getPasajerosDeLista(CategoriaPasajero categoria) {
        switch (categoria) {
            case Esporadico:
                return esporadico;
            case Estandar:
                return estandar;
            case Frecuente:
                return frecuente;
            case Nuevo:
                return nuevo;
            default:
                return platino;
        }
    }
}
