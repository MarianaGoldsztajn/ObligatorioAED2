package uy.edu.ort.aed2.obligatorio.Pasajeros;

import uy.edu.ort.aed2.obligatorio.Pasajeros.Enum.CategoriaPasajero;
import uy.edu.ort.aed2.obligatorio.Utils;

public class NodoPasajero {
    private String id;
    private int idNumberic;
    private String name;
    private String phone;
    private CategoriaPasajero category;
    private NodoPasajero right;
    private NodoPasajero left;

    public NodoPasajero(String id, String name, String phone, CategoriaPasajero category) {
        this.id = id;
        this.idNumberic = saveNumericId(id);
        this.name = name;
        this.phone = phone;
        this.category = category;
    }

    public int saveNumericId(String id){
        id = Utils.getIdWithoutSimbols(id);
        if(Utils.isNumeric(id)){
            return Integer.parseInt(id);
        }
        return 0;
    }

    public CategoriaPasajero getCategory() {
        return category;
    }

    public String getStringId(){
        return this.id;
    }
    public int getNumericId(){
        return idNumberic;
    }
    public void setLeft(NodoPasajero left) {
        this.left = left;
    }

    public void setRight(NodoPasajero right) {
        this.right = right;
    }

    public NodoPasajero getLeft() {
        return left;
    }

    public NodoPasajero getRight() {
        return right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public String getPassengerInfoLine(){
        return "Id: " + this.id + ", Name: " + this.name + ", Phone: " + this.phone + ", Category: " + this.category.name();
    }


}