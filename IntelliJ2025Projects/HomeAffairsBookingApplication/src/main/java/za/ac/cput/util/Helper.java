package za.ac.cput.util;

public class Helper {
    public static boolean isStringNullOrEmpty(String s){
        if(s == null|| s.isEmpty()) {
            return true;
        }
        return false;
    }

}
