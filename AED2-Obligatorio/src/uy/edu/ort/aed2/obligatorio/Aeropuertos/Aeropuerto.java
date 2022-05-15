package uy.edu.ort.aed2.obligatorio.Aeropuertos;

public class Aeropuerto {
    //Arbol?
    private String Code;
    private String Name;
    private Aeropuerto right;
    private Aeropuerto left;

    public Aeropuerto(String code, String name){
        this.Code = code;
        this.Name = name;
    }

    public String getCode(){
        return this.Code;
    }

    public String getName(){
        return this.Name;
    }

    public void setLeft(Aeropuerto left) {
        this.left = left;
    }

    public void setRight(Aeropuerto right) {
        this.right = right;
    }

    public Aeropuerto getLeft() {
        return left;
    }

    public Aeropuerto getRight() {
        return right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
