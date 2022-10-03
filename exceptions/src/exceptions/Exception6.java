package exceptions;

import java.io.*;

public class Exception6 {
    //main metotta bu tarz exception fırlatmak JVM aaçsından terminate olmasına sebep olur
    public static void main(String[] args) {


        foo(); //JVM burada terminate oldu hata fırlattı ve sonra devam etmedi

    }

    private static void foo() {


        try(InputStream in = new FileInputStream(new File("missingfile.txt"));)
        {
            System.out.println("File will be open...");
            System.out.println(1 / 0);
            System.out.println("File has opened...");
        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
        } catch (ArithmeticException e){
            System.out.println("An aritmetic exception occured...");
        } catch (IOException e) {
            System.out.println("IO Stream closed...");
        }
        }
    }


