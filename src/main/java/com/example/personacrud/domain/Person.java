package com.example.personacrud.domain;
import co.com.sofka.domain.generic.AggregateRoot;
import co.com.sofka.domain.generic.Identity;
import com.example.personacrud.domain.values.PersonId;
import com.example.personacrud.domain.values.IsProfessional;
import com.example.personacrud.domain.values.Name;
import com.example.personacrud.domain.values.Phone;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection  = "PersonLopera")
public class Person extends AggregateRoot<PersonId> {

    @Id
    protected String idJhon;

    protected Name name;
    protected Phone phone;
    protected IsProfessional isProfessional;

    public Person(PersonId entityId, Name name, Phone phone, IsProfessional isProfessional) {
        super(entityId);
        this.idJhon = entityId.value();
        this.name = name;
        this.phone = phone;
        this.isProfessional = isProfessional;
    }

    public void setIdJhon(String idJhon) {
        this.idJhon = idJhon;
    }

    public String getIdJhon() {
        return idJhon;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public IsProfessional getIsProfessional() {
        return isProfessional;
    }
}
