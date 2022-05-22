package uy.edu.ort.aed2.obligatorio;

import uy.edu.ort.aed2.obligatorio.Pasajeros.Enum.CategoriaPasajero;
import uy.edu.ort.aed2.obligatorio.Pasajeros.ArbolPasajero.PasajeroABB;
import uy.edu.ort.aed2.obligatorio.Pasajeros.ControlPasajero;

public class Main {

    public static void main(String[] args) {

        ControlPasajero controlPasajero = new ControlPasajero();


        //NodoPasajero p = new NodoPasajero("111.111-2", "Mariana", "098775632", CategoriaPasajero.Platino);
        PasajeroABB pABB = new PasajeroABB();
        Retorno ret = controlPasajero.agregarPasajero("111.111-1", "Mariana", "098775632", CategoriaPasajero.Platino);

        Retorno ret2 = controlPasajero.agregarPasajero("111.111-0", "Eugenia", "097856325", CategoriaPasajero.Platino);

        Retorno ret3 = controlPasajero.agregarPasajero("111.111-3", "Juan", "091856985", CategoriaPasajero.Frecuente);

        Retorno ret4 = controlPasajero.agregarPasajero("111.111-2", "Lola", "091856985", CategoriaPasajero.Frecuente);

        System.out.println("-----------BUSCAR PASAJEROS----------------------");
        System.out.println(controlPasajero.encontrarPasajero("111.111-2"));
        System.out.println(controlPasajero.encontrarPasajero("111.111-3"));

        System.out.println("-----------LISTAR ASCENDENTE----------------------");
        System.out.println(controlPasajero.listarAscendente());
        System.out.println("-----------LISTAR DESCENDENTE----------------------");
        System.out.println(controlPasajero.listarDescendente());

        System.out.println("-----------LISTAR CATEGORIA----------------------");
        System.out.println("Platino:");
        System.out.println(controlPasajero.getIdsPorCategoria(CategoriaPasajero.Platino));
        System.out.println("Frecuente:");
        System.out.println(controlPasajero.getIdsPorCategoria(CategoriaPasajero.Frecuente));
        System.out.println("Estandar:");
        //ControlCategoriasPasajeros cp = new ControlCategoriasPasajeros();

        System.out.println(controlPasajero.getIdsPorCategoria(CategoriaPasajero.Estandar));

    }
}
