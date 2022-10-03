package exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Exception3 {
//main metotta bu tarz exception fırlatmak JVM aaçsından terminate olmasına sebep olur
    public static void main(String[] args) throws FileNotFoundException {

        foo(); //JVM burada terminate oldu hata fırlattı ve sonra devam etmedi

    }

    private static void foo() throws FileNotFoundException {
        try {
            System.out.println("File will be open...");
            InputStream in = new FileInputStream("F:\\Intelligy\\Spring-Boot-Demo\\exceptions\\src\\exceptions\\missingfile.txt");
            System.out.println(1/0);
            System.out.println("File has opened...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }
}

