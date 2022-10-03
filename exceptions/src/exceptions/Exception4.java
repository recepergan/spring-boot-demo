package exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Exception4 {
    //main metotta bu tarz exception fırlatmak JVM aaçsından terminate olmasına sebep olur
    public static void main(String[] args) {


        foo(); //JVM burada terminate oldu hata fırlattı ve sonra devam etmedi

    }

    private static void foo() {
        System.out.println("File will be open...");
        try {
            InputStream in = new FileInputStream("F:\\Intelligy\\Spring-Boot-Demo\\exceptions\\src\\exceptions\\missingfile.txt");
            System.out.println(1 / 0);
        } catch (FileNotFoundException | ArithmeticException | NullPointerException e) {
            System.out.println("An exception occured...");
        }


        System.out.println("File has opened...");
    }
}

