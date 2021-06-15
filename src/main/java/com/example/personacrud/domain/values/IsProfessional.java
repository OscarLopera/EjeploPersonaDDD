package com.example.personacrud.domain.values;

import co.com.sofka.domain.generic.ValueObject;

public class IsProfessional implements ValueObject<Boolean> {

    private final Boolean value;

    public IsProfessional(Boolean value){ this.value= value;}

    @Override
    public Boolean value(){ return value; }

}
