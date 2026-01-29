package com.example.unittesting.repository;

import com.example.unittesting.models.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@ActiveProfiles("test")
public class PersonRepoTest {
    @Autowired
    private PersonRepo personRepo;
    //findbyname -test
    @Test
    public void testExistsById(){
        Person person = new Person(null,"Test Name","City");
        person = personRepo.save(person);
        assertThat(person).isNotNull();
        boolean exists = personRepo.existsById(person.getPersonId());
        assertThat(exists).isTrue();
    }
    @Test
    public void testFindByName(){
        Person person = new Person(null,"Test Name","Nagpur");
        person = personRepo.save(person);
        Person result = personRepo.findByName(person.getName());
        assertThat(result).isNotNull();
        assertThat(result.getCity()).isEqualTo("Nagpur");
        assertThat(result.getName()).isEqualTo("Test Name");

    }
}
