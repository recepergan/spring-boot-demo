package com.example.springboot.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/*@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode  //(exclude = )
@ToString*/
//@Data  -- > getter,setter,equalsandhashcode,tostring,@requiredargsconstructor(final olan alanla ilgili constrructor oluşturrur
//@value //immutable sınıflar oluşturmanızı sağlar
@Data
@NoArgsConstructor
//@Entity
public class Student {

   // @Id
    private int id;
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String fullname;
   // @NonNull
    private int schoolNumber;
    private int age;
}
