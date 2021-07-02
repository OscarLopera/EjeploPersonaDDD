package com.example.personacrud.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import com.example.personacrud.domain.Person;
import com.example.personacrud.domain.commands.UpdatePerson;
import com.example.personacrud.repository.IPersonDataRepository;
import com.example.personacrud.repository.PersonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonUseCase extends UseCase<RequestCommand<UpdatePerson>, com.example.personacrud.useCases.UpdatePersonUseCase.Response> {

    @Autowired
    private IPersonDataRepository data;

    @Override
    public void executeUseCase(RequestCommand<UpdatePerson> updatePersonRequestCommand) {


        var command = updatePersonRequestCommand.getCommand();
        var person = new Person(command.personId(),command.name(), command.phone(), command.isProfessional());
        data.save(transform(person));
        emit().onResponse(new Response(person));

    }

    public PersonData transform(Person person) {
        PersonData personData = new PersonData(person.getIdJhon(), person.getName().value(),person.getPhone().value(), person.getIsProfessional().value());
        return personData ;
    }

    public static class Response implements UseCase.ResponseValues{

        private Person response;


        public Response(Person person) {
            this.response=person;
        }

        public Person getResponse() {
            return response;
        }

        public void setResponse(Person response) {
            this.response = response;
        }
    }
}
