package com.example.unittesting.service;

import com.example.unittesting.models.Person;
import com.example.unittesting.repository.PersonRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepo personRepo;
    @InjectMocks
    private PersonService personService;
    //DeleteByid
    @Test
    void getAllPerson(){
        Person person1 = new Person(null,"P1","Nagpur");
        Person person2 = new Person(null,"P2","Delhi");
        given(personRepo.findAll()).willReturn(List.of(person1,person2));
        List<Person> personList = personService.getAllPerson();
        assertThat(personList).isNotNull();
        assertThat(personList.size()).isEqualTo(2);
        verify(personRepo).findAll();
    }
    //Create person
    @Test
    void deleteById(){
        willDoNothing().given(personRepo).deleteById(1);
        personService.DeleteById(1);
        verify(personRepo).deleteById(1);
    }
    @Test
    void shouldSavePerson(){
        Person input = new Person(null,"Rahul","Nagpur");
        Person saved = new Person(10,"Rahul","Pune");
        given(personRepo.save(input)).willReturn(saved);
        Person result = personService.createPerson(input);
        assertThat(result.getPersonId()).isEqualTo(10);
        verify(personRepo).save(input);
    }
    @Test
    void getPersonByIdSuccess(){
        Person p = new Person(1,"Nikhil","Nagpur");
        given(personRepo.findById(1)).willReturn(Optional.of(p));
        Person result = personService.getPersonById(1);
        assertThat(result.getName()).isEqualTo("Nikhil");
        verify(personRepo).findById(1);
    }
    //get person by id test case failed
    @Test
    void getPersonByIdFailed(){
        given(personRepo.findById(1))
                .willReturn(Optional.empty());
        assertThatThrownBy(()-> personService.getPersonById(1))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Person not found");
    }
}
