package com.example.personacrud.useCases;

import com.example.personacrud.domain.Person;
import com.example.personacrud.repository.IPersonDataRepository;
import com.example.personacrud.repository.PersonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransformacionUseCase {

    @Autowired
    private IPersonDataRepository data;

    public PersonData transform(Person person) {
        PersonData personData = new PersonData(person.getIdJhon(), person.getName().value(),person.getPhone().value(), person.getIsProfessional().value());
        return personData ;
    }


    public Iterable<PersonData> listar(){
        return data.findAll();
    }

    public PersonData listarId(String id) {
        return data.findById(id).orElseThrow(RuntimeException::new);
    }

    public String delete(String id) {

        try {
            data.deleteById(id);
            return "Se realizo el borrado con exito";
        }catch(Exception e){
            return "No se pudo realizar el borrado con exito";
        }
    }
}
