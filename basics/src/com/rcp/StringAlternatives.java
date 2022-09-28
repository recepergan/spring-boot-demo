package com.rcp;

public class StringAlternatives {
    public static void main(String[] args) {

        //immutable
        String str = "recep";
        System.out.println("String memory : " + str.hashCode());

        str += "ergan";
        System.out.println("String memory : " + str.hashCode());
        System.out.println("String :" +str);

        System.out.println("--------------");

        //mutable
        //asyncronized-thread-safe
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("recep");
        System.out.println("string memory id :" +stringBuilder.hashCode());
        stringBuilder.append("ergan");
        System.out.println("string memory id :" +stringBuilder.hashCode());
        System.out.println("String : " + stringBuilder);


       // syncronized-thread-safe
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("recep");
        System.out.println("string memory id :" +stringBuffer.hashCode());
        stringBuffer.append("ergan");
        System.out.println("string memory id :" +stringBuffer.hashCode());
        System.out.println("String : " + stringBuilder);



    }
}
