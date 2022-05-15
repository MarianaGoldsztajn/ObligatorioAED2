package uy.edu.ort.aed2.obligatorio.Aeropuertos;

import uy.edu.ort.aed2.obligatorio.Retorno;

public class AeropuertoABB {
    private Aeropuerto root;
    private int MaxAirports;
    private int CurrentAirports;

    public Retorno addAirport(String code, String name){
        if(code == null || name == null ){
            return new Retorno(Retorno.Resultado.ERROR_2);
        }else{
            Aeropuerto airport = new Aeropuerto(code, name);
            Retorno retExistingPassenger = checkExistingAirport(code);
            if(retExistingPassenger.resultado.equals(Retorno.Resultado.OK)){
                    return save(airport);
            }else{
                return new Retorno(Retorno.Resultado.ERROR_1);
            }
        }
    }

    public Retorno checkExistingAirport(String code) {
        if(existingAirportRec(this.root, code)){
            return new Retorno(Retorno.Resultado.ERROR_3);
        }else{
            return new Retorno(Retorno.Resultado.OK);
        }
    }

    public boolean existingAirportRec(Aeropuerto airport, String code){
        if(airport == null) {
            return false;
        }else if(airport.getCode() == code) {
            return true;
        }else {
            return existingAirportRec(airport.getLeft(), code) || existingAirportRec(airport.getRight(), code);
        }
    }

    public Retorno save(Aeropuerto newAirport) {
        if(this.CurrentAirports < this.MaxAirports){
            if (root == null) {
                root = newAirport;
            } else {
                saveRecursive(root, newAirport);
            }
            ++this.CurrentAirports;
            return new Retorno(Retorno.Resultado.OK);
        }else{
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
    }
    private void saveRecursive(Aeropuerto airport, Aeropuerto newAirport) {
        if (true) {
            if (airport.getRight() == null) {
                airport.setRight(newAirport);
            } else {
                saveRecursive(airport.getRight(), newAirport);
            }
        } else {
            if (airport.getLeft() == null) {
                airport.setLeft(newAirport);
            } else {
                saveRecursive(airport.getLeft(), newAirport);
            }
        }
    }


}
