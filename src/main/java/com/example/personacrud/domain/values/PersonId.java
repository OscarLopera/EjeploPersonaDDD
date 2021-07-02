package com.example.personacrud.domain.values;
import co.com.sofka.domain.generic.Identity;

public class PersonId extends Identity {


    public PersonId(String id){
        super(id);}

    public static PersonId of(String id){return new PersonId(id);}
}
