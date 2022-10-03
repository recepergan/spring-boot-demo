package exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Exception2 {
//main metotta bu tarz exception fırlatmak JVM aaçsından terminate olmasına sebep olur
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Test 1");
        System.out.println("Test 2");
        System.out.println("Test 3");
        foo(); //JVM burada terminate oldu hata fırlattı ve sonra devam etmedi
        System.out.println("Test 4");
        System.out.println("Test 5");
    }

    private static void foo() throws FileNotFoundException {
        System.out.println("File will be open...");
        InputStream in = new FileInputStream("missingfile.txt");
        System.out.println("File has opened...");
    }
}

