package com.example.personacrud.domain;

import com.example.personacrud.domain.values.IsProfessional;
import com.example.personacrud.domain.values.Name;
import com.example.personacrud.domain.values.Phone;

public final class PersonBuilder {
    protected Name name;
    protected Phone phone;
    protected IsProfessional isProfessional;

    private PersonBuilder() {
    }

    public static PersonBuilder aPerson() {
        return new PersonBuilder();
    }

    public PersonBuilder withName(Name name) {
        this.name = name;
        return this;
    }

    public PersonBuilder withPhone(Phone phone) {
        this.phone = phone;
        return this;
    }

    public PersonBuilder withIsProfessional(IsProfessional isProfessional) {
        this.isProfessional = isProfessional;
        return this;
    }

}
