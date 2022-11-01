package exceptions;

import java.util.Locale;

public class Exception10 {
    public static void main(String[] args) {
        foo();
    }

    //Bu şekilde finally bloğunda hata fırlatılamaz asıl hatayı absorbe ederiz
    private static void foo() {

        try {
            String a = null;
            System.out.println(a.toLowerCase());
        } catch (NullPointerException e) {
            throw new NullPointerException("Null pointer exception occures..");
        } finally {
            throw new RuntimeException("Runtime exception occures");
        }
    }
}
