package com.zlb.springboot_jpa.controller;

import com.zlb.springboot_jpa.entity.Person;
import com.zlb.springboot_jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    // 增删查改
    @PostMapping("/save")
    public String save(@RequestBody  Person person){
        personService.save(person);
        return "";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        personService.deleteById(id);
        return "";
    }

    @GetMapping("/findById/{id}")
    public Person findById(Long id){
        return personService.findPerson(id);
    }

    @GetMapping("/findAll")
    public List<Person> findAll(){
        return  personService.findPerson();
    }

    @PatchMapping("/update")
    public String update(@RequestBody Person person){
        personService.update(person);
        return "";
    }


}
