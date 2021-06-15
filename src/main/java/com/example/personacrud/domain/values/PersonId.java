package com.example.personacrud.domain.values;

import co.com.sofka.domain.generic.Identity;
import com.example.personacrud.domain.Person;

public class PersonId extends Identity {

    private PersonId(String id){ super(id);}

    public static PersonId of(String id){return new PersonId(id);}
}
