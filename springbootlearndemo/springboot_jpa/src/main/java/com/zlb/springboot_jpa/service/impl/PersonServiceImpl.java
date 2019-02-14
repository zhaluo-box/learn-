package com.zlb.springboot_jpa.service.impl;

import com.zlb.springboot_jpa.dao.PersonRepository;
import com.zlb.springboot_jpa.entity.Person;
import com.zlb.springboot_jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;


    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void update(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person findPerson(Long id) {
        return personRepository.findPersonById(id);
    }


    @Override
    public List<Person> findPerson() {
        return personRepository.findAll();
    }
}
