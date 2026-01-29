package com.example.unittesting.repository;

import com.example.unittesting.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepo extends JpaRepository<Person,Integer>{
    @Override
    boolean existsById(Integer integer);
    //existsBy{FieldName}
    //findBy{fieldName}
    Person findByName(String name);
}
