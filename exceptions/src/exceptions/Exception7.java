package exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Exception7 {
    public static void main(String[] args) {

        System.out.println("Entered main");
        methodA();
        System.out.println("Exist from main");
    }

    private static void methodA() {

        System.out.println("Entered methodA");
        methodB();
        System.out.println("Exist from methodA");
    }

    private static void methodB() {
        System.out.println("Entered methodB");
        methodC();
        System.out.println("Exist from methodB");
    }

    private static void methodC() {
        System.out.println("Entered methodC");
        try {
            InputStream in = new FileInputStream("missingfile.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        }
        System.out.println("Exist from methodC");
    }

}
