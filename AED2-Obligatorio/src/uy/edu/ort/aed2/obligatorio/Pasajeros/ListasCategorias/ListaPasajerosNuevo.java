package uy.edu.ort.aed2.obligatorio.Pasajeros.ListasCategorias;

import uy.edu.ort.aed2.obligatorio.Generico.Lista;
import uy.edu.ort.aed2.obligatorio.Pasajeros.Enum.CategoriaPasajero;
import uy.edu.ort.aed2.obligatorio.Pasajeros.ArbolPasajero.Pasajero;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ListaPasajerosNuevo extends ListaCategoriaPasajero {
    private CategoriaPasajero categoria = CategoriaPasajero.Nuevo;
}