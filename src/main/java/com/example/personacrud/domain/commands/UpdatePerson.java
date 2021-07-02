package com.example.personacrud.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.example.personacrud.domain.values.IsProfessional;
import com.example.personacrud.domain.values.Name;
import com.example.personacrud.domain.values.PersonId;
import com.example.personacrud.domain.values.Phone;

public class UpdatePerson implements Command {

    private final PersonId personId;
    private  final Name name;
    private final Phone phone;
    private final IsProfessional isProfessional;

    public UpdatePerson(PersonId personId, Name name, Phone phone, IsProfessional isProfessional){
        this.personId = personId;
        this.name = name;
        this.phone = phone;
        this.isProfessional = isProfessional;
    }

    public PersonId personId() { return personId; }

    public Name name() { return name; }

    public Phone phone() { return phone; }

    public IsProfessional isProfessional() { return isProfessional; }
}
