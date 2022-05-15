package uy.edu.ort.aed2.obligatorio.Pasajeros;

import uy.edu.ort.aed2.obligatorio.Pasajeros.Enum.CategoriaPasajero;
import uy.edu.ort.aed2.obligatorio.Retorno;
import uy.edu.ort.aed2.obligatorio.Utils;

public class PasajeroABB {
    private NodoPasajero root;


    public PasajeroABB(){
    }

    public boolean SavePassenger(){
        return true;
    }

    public static Retorno validPassengerId(String id) {
        int length = id.length();
        if(id.length() == 9 || id.length() == 11){
            if (id.charAt(length - 2) == '-' && (id.length() == 11 && id.charAt(1) == '.' && id.charAt(5) == '.') || (id.length() == 9 && id.charAt(3) == '.')) {
                id = Utils.getIdWithoutSimbols(id);
                if (Utils.isNumeric(id)) {
                    return new Retorno(Retorno.Resultado.OK);
                }
            }
        }
        return new Retorno(Retorno.Resultado.ERROR_2);
    }


    public Retorno checkExistingPassenger(String id) {
        if(existingPassengerRec(this.root, id)){
            return new Retorno(Retorno.Resultado.ERROR_3);
        }else{
            return new Retorno(Retorno.Resultado.OK);
        }
    }

    public static boolean existingPassengerRec(NodoPasajero passenger, String id){
        if(passenger == null) {
            return false;
        }else if(passenger.getStringId() == id) {
            return true;
        }else {
            return existingPassengerRec(passenger.getLeft(), id) || existingPassengerRec(passenger.getRight(), id);
        }
    }

    public Retorno addPassenger(String id, String name, String phone, CategoriaPasajero category){
        if(id == null || name == null || phone == null || category == null){
            return new Retorno(Retorno.Resultado.ERROR_1);
        }else{
            NodoPasajero passenger = new NodoPasajero(id, name, phone, category);
            Retorno retValidPassengerId = validPassengerId(passenger.getStringId());
            Retorno retExistingPassenger = checkExistingPassenger(passenger.getStringId());
            if(retValidPassengerId.resultado.equals(Retorno.Resultado.OK)){
                if(retExistingPassenger.resultado.equals(Retorno.Resultado.OK)){
                    save(passenger);
                    //this.pc.addToHashtable(category, id);
                    return new Retorno(Retorno.Resultado.OK);
                }else{
                    return retExistingPassenger;
                }
            }else{
                return retValidPassengerId;
            }
        }
    }

    public void save(NodoPasajero newPassenger) {
        if (root == null) {
            root = newPassenger;
        } else {
            saveRecursive(root, newPassenger);
        }
    }
    private void saveRecursive(NodoPasajero passenger, NodoPasajero newPassenger) {
        if (passenger.getNumericId() > newPassenger.getNumericId()) {
            if (passenger.getRight() == null) {
                passenger.setRight(newPassenger);
            } else {
                saveRecursive(passenger.getRight(), newPassenger);
            }
        } else {
            if (passenger.getLeft() == null) {
                passenger.setLeft(newPassenger);
            } else {
                saveRecursive(passenger.getLeft(), newPassenger);
            }
        }
    }

    public String findPassenger(String id) {
        NodoPasajero passenger = findPassengerRec(this.root, id);
        if( passenger != null){
            return passenger.getPassengerInfoLine();
        }else{
            return "The passenger was not found in the system.";
        }
    }
    public String listAscending(){
        if(this.root == null){
            return "There are no passengers in the system.";
        }else if(this.root.isLeaf()){
            return this.root.getPassengerInfoLine();
        }else {
            String text = listAscendingRec(this.root, "");
            return text;
        }
    }

    public String listAscendingRec(NodoPasajero passenger, String text) {
        if(passenger != null) {
            text = listAscendingRec(passenger.getRight(), text);
            text += passenger.getPassengerInfoLine() + "|";
            text = listAscendingRec(passenger.getLeft(), text);
        }
        return text;
    }
    public String listDescending(){
        if(this.root == null){
            return "There are no passengers in the system.";
        }else if(this.root.isLeaf()){
            return this.root.getPassengerInfoLine();
        }else {
            return listDescendingRec(this.root, "");
        }
    }

    private String listDescendingRec(NodoPasajero passenger, String text) {
        if(passenger != null) {
            text = listDescendingRec(passenger.getLeft(), text);
            text += passenger.getPassengerInfoLine() + "|";
            text = listDescendingRec(passenger.getRight(), text);
        }
        return text;
    }

    public static NodoPasajero findPassengerRec(NodoPasajero passenger, String id){
        if(passenger == null) {
            return null;
        }else if(passenger.getStringId() == id) {
            return passenger;
        }else {
            NodoPasajero passenger1 = findPassengerRec(passenger.getLeft(), id);
            NodoPasajero passenger2 = findPassengerRec(passenger.getRight(), id);
            if(passenger1 != null){
                return passenger1;
            }else if(passenger2 != null){
                return passenger2;
            }else{
                return null;
            }
        }
    }

    //Falta listar por categoria //Guardar un arbol aparte por categoria?

}
