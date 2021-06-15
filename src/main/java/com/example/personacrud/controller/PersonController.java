package com.example.personacrud.controller;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.example.personacrud.domain.commands.CreatePerson;
import com.example.personacrud.domain.values.IsProfessional;
import com.example.personacrud.domain.values.Name;
import com.example.personacrud.domain.values.PersonId;
import com.example.personacrud.domain.values.Phone;
import com.example.personacrud.useCases.CreatePersonUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class PersonController {

    @Autowired
    private CreatePersonUseCase useCase;

    @PostMapping(value = "api/{id}/{name}/{phone}/{professional}")
    public String save(@PathVariable("id")String id,
                       @PathVariable("name")String name,
                       @PathVariable("phone")String phone,
                       @PathVariable("professional")Boolean professional){
        var command = new CreatePerson(PersonId.of(id), new Name(name), new Phone(phone), new IsProfessional(professional));
        CreatePersonUseCase.Response personCreated = executedUseCase(command);
        return (personCreated.getResponse().getName().value()+ " "+personCreated.getResponse().getPhone().value()+ " "+personCreated.getResponse().getIsProfessional().value());
    }

    private CreatePersonUseCase.Response executedUseCase(CreatePerson command) {
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();
        var PersonCreated = events;
        return PersonCreated;
    }
}
