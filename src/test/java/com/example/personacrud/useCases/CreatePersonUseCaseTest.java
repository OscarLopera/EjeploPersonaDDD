package com.example.personacrud.useCases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.example.personacrud.domain.Person;
import com.example.personacrud.domain.commands.CreatePerson;
import com.example.personacrud.domain.events.PersonCreated;
import com.example.personacrud.domain.values.IsProfessional;
import com.example.personacrud.domain.values.Name;
import com.example.personacrud.domain.values.PersonId;
import com.example.personacrud.domain.values.Phone;
import com.example.personacrud.repository.IPersonRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
public class CreatePersonUseCaseTest {

    @Autowired
    private CreatePersonUseCase usecase;

    @InjectMocks
    private IPersonRepository iPersonRepository;

    @InjectMocks
    private CrudRepository crudRepository;


    @Test
    public void createPersonTest(){
       /*   Mockito.when(crudRepository.save(any())).thenReturn(new Person(PersonId.of("123"), new Name("Oscar"), new Phone("3124745"),
                new IsProfessional(Boolean.TRUE)));

        var command = new CreatePerson( PersonId.of("123"), new Name("Oscar"), new Phone("3124745"),
                new IsProfessional(Boolean.TRUE));

        PersonCreated personCreated = executedUseCase(command);

        Assertions.assertEquals("123", personCreated.personId().value());*/
        System.out.println("dshgafjwd");
    }

    /*private PersonCreated executedUseCase(CreatePerson command){
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var PersonCreated = (PersonCreated) events.get(0);
        return PersonCreated;
    }*/
}