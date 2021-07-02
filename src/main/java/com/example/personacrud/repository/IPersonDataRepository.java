package com.example.personacrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonDataRepository extends CrudRepository<PersonData, String> {
}
