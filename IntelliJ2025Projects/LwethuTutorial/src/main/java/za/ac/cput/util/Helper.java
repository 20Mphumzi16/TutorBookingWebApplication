package za.ac.cput.util;

public class Helper {
    public static boolean isStringNullOrEmpty(String str) {
        return str.isEmpty();
    }
    public static boolean isObjectNullOrEmpty(Object obj) {
        return obj == null;
    }
    public static boolean isInvalidAge(int age){
        return age<=0;
    }
}
