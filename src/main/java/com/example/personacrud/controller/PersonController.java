package com.example.personacrud.controller;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.example.personacrud.domain.commands.CreatePerson;
import com.example.personacrud.domain.commands.UpdatePerson;
import com.example.personacrud.domain.values.IsProfessional;
import com.example.personacrud.domain.values.Name;
import com.example.personacrud.domain.values.PersonId;
import com.example.personacrud.domain.values.Phone;
import com.example.personacrud.repository.PersonData;
import com.example.personacrud.useCases.CreatePersonUseCase;
import com.example.personacrud.useCases.TransformacionUseCase;
import com.example.personacrud.useCases.UpdatePersonUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
public class PersonController {

    @Autowired
    private CreatePersonUseCase createPersonUseCase;

    @Autowired
    private UpdatePersonUseCase updatePersonUseCase;

    @Autowired
    private TransformacionUseCase transformacionUseCase;



    @PostMapping(value = "api/guardar/{id}/{name}/{phone}/{professional}")
    public String guardar(@PathVariable("id")String id,
                       @PathVariable("name")String name,
                       @PathVariable("phone")String phone,
                       @PathVariable("professional")Boolean professional){
        var command = new CreatePerson(PersonId.of(id), new Name(name), new Phone(phone), new IsProfessional(professional));
        CreatePersonUseCase.Response personCreated = executedUseCase(command);

        String string = "{"
                + "\"idPerson\":" + "\""+personCreated.getResponse().identity()+"\"" + ","
                +"\"name\":" + "\""+personCreated.getResponse().getName().value() +"\"" + ","
                +"\"phone\":" + "\""+personCreated.getResponse().getPhone().value()+ "\""+","
                +"\"isProssional\":" + personCreated.getResponse().getIsProfessional().value()
                +"}";

        return string;

    }

    private CreatePersonUseCase.Response executedUseCase(CreatePerson command) {
        var events = UseCaseHandler.getInstance()
                .syncExecutor(createPersonUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var PersonCreated = events;
        return PersonCreated;
    }

    @PutMapping(value = "api/actualizar/{id}/{name}/{phone}/{professional}")
    public String actualizar(@PathVariable("id")String id,
                       @PathVariable("name")String name,
                       @PathVariable("phone")String phone,
                       @PathVariable("professional")Boolean professional){
        var command = new UpdatePerson(PersonId.of(id), new Name(name), new Phone(phone), new IsProfessional(professional));
        UpdatePersonUseCase.Response personUpdated = executedUseCase(command);

        String string = "{"
                + "\"idPerson\":" + "\""+personUpdated.getResponse().identity()+"\"" + ","
                +"\"name\":" + "\""+personUpdated.getResponse().getName().value() +"\"" + ","
                +"\"phone\":" + "\""+personUpdated.getResponse().getPhone().value()+ "\""+","
                +"\"isProssional\":" + personUpdated.getResponse().getIsProfessional().value()
                +"}";

        return string;

    }

    private UpdatePersonUseCase.Response executedUseCase(UpdatePerson command) {
        var events = UseCaseHandler.getInstance()
                .syncExecutor(updatePersonUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var PersonUpdated = events;
        return (UpdatePersonUseCase.Response) PersonUpdated;
    }

    @GetMapping(value = "api/findPersons")
    public Iterable<PersonData> listar(){
        return (transformacionUseCase.listar());
    }

    @GetMapping(value = "api/findPerson/{id}")
    public PersonData listarId(@PathVariable("id") String id){
        return (transformacionUseCase.listarId(id));
    }

    @DeleteMapping(value = "api/delete/{id}")
    public String delete(@PathVariable("id") String id){
        return (transformacionUseCase.delete(id));
    }
}
