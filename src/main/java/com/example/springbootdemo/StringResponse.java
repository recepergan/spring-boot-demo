package com.example.springbootdemo;
 // import javax.xml.bind.annotation.XmlRootELement;

  //@XmlRootELement
public class StringResponse {
    private String name;


    public StringResponse(String name) {
        this.name = name;

    }

    //Xml için boş constructor koyduk
    public StringResponse() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
