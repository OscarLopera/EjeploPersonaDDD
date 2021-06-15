package com.example.personacrud.repository;

import com.example.personacrud.domain.Person;
import com.example.personacrud.domain.values.PersonId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends CrudRepository<Person, PersonId> {

}
