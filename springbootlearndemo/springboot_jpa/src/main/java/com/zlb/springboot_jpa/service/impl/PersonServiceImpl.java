package com.zlb.springboot_jpa.service.impl;

import com.zlb.springboot_jpa.dao.PersonRepository;
import com.zlb.springboot_jpa.entity.Person;
import com.zlb.springboot_jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public List<Person> findByAddress(String address) {
        return personRepository.findPersonByAddress(address);
    }

    @Override
    public Person findPersonByNameAndAddress(String name, String address) {
        return personRepository.findByNameAndAddress(name,address);
    }

    @Override
    public Person withNameAndAddress(String name, String address) {
        return personRepository.withNameAndAddressQuery(name,"%"+address+"%");
    }

    @Override
    public Person withNameAndAddressQuery(String name, String address) {
        return personRepository.withNameAndAddressQuery2(name,address);
    }

    /**
     * 格式
     *          升序/降序,"属性名称'
     * @return
     */
    @Override
    public List<Person> sort() {
        return personRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
    }

    @Override
    public Page<Person> page() {
        return personRepository.findAll(new PageRequest(1,2));
    }
}
