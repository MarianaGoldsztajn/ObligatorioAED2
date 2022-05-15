package uy.edu.ort.aed2.obligatorio;

public class Utils {

    public static String getIdWithoutSimbols(String id){
        id = id.replace(".", "");
        id = id.replace("-", "");

        return id;
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
