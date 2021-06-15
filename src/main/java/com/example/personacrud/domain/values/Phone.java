package com.example.personacrud.domain.values;

import co.com.sofka.domain.generic.ValueObject;

public class Phone implements ValueObject<String> {

    private final String value;

    public  Phone(String value){ this.value = value;}

    @Override
    public String value() { return value; }
}
