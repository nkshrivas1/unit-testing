package com.example.unittesting.service;

import com.example.unittesting.models.Person;
import com.example.unittesting.repository.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepo personRepo;
    public List<Person> getAllPerson(){
        return personRepo.findAll();
    }
    public void DeleteById(Integer id){
        personRepo.deleteById(id);
    }
    public Person createPerson(Person person){
        Person newPerson = new Person();
        newPerson.setName(person.getName());
        newPerson.setCity(person.getCity());
        return personRepo.save(person);
    }
    public Person getPersonById(Integer id){
        return personRepo.findById(id).orElseThrow(()->
                new RuntimeException("Person not found"));
    }
}
