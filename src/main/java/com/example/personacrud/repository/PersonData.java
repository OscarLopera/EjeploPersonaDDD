package com.example.personacrud.repository;

;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection  = "PersonLopera")
public class PersonData {

    @Id
    protected String id;
    protected String name;
    protected String phone;
    protected Boolean isProfessional;

    public PersonData(String id, String name, String phone, Boolean isProfessional) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.isProfessional = isProfessional;
    }

    public PersonData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String idJhon) {
        this.id = idJhon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getProfessional() {
        return isProfessional;
    }

    public void setProfessional(Boolean professional) {
        isProfessional = professional;
    }
}
