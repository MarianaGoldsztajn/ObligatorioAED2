package uy.edu.ort.aed2.obligatorio.Pasajeros;

import uy.edu.ort.aed2.obligatorio.Pasajeros.Enum.CategoriaPasajero;
import uy.edu.ort.aed2.obligatorio.Retorno;
import uy.edu.ort.aed2.obligatorio.Utils;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class NodoPasajero {
    private String Id;
    private int IdNumerico;
    private String Nombre;
    private String Telefono;
    private CategoriaPasajero Categoria;
    private NodoPasajero Derecha;
    private NodoPasajero Izquierda;

    public NodoPasajero(String id, String name, String phone, CategoriaPasajero category) {
        this.Id = id;
        this.IdNumerico = getIdNumerico(id);
        this.Nombre = name;
        this.Telefono = phone;
        this.Categoria = category;
    }

    public int getIdNumerico(String id){
        id = Utils.getIdWithoutSimbols(id);
        if(Utils.isNumeric(id)){
            return Integer.parseInt(id);
        }
        return 0;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getIdNumerico() {
        return IdNumerico;
    }

    public void setIdNumerico(int idNumerico) {
        IdNumerico = idNumerico;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public CategoriaPasajero getCategoria() {
        return Categoria;
    }

    public void setCategoria(CategoriaPasajero categoria) {
        Categoria = categoria;
    }

    public NodoPasajero getDerecha() {
        return Derecha;
    }

    public void setDerecha(NodoPasajero derecha) {
        Derecha = derecha;
    }

    public NodoPasajero getIzquierda() {
        return Izquierda;
    }

    public void setIzquierda(NodoPasajero izquierda) {
        Izquierda = izquierda;
    }

    public boolean isLeaf() {
        return this.getIzquierda() == null && this.getDerecha() == null;
    }

    public String getInfoPasajero(){
        return "Id: " + this.getId() + ", Nombre: " + this.getNombre() + ", Teléfono: " + this.getTelefono() + ", Categoría: " + this.getCategoria().name();
    }

    public static Retorno validarId(final String input) {

        final Pattern pattern = Pattern.compile("/^\\d{1}\\.\\d{3}\\.\\d{3}-\\d{1}$/g", Pattern.CASE_INSENSITIVE);

        final Matcher matcher = pattern.matcher(input);

        if(matcher.matches()){
            return new Retorno(Retorno.Resultado.OK);
        }else{
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
    }

    public static boolean datosValidos(NodoPasajero pasajero){
        return !(pasajero.getId() == null || pasajero.getNombre() == null || pasajero.getTelefono() == null || pasajero.getCategoria() == null);
    }

}