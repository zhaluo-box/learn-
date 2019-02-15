package com.zlb.springboot_jpa.controller;

import com.zlb.springboot_jpa.dao.PersonRepository;
import com.zlb.springboot_jpa.entity.Person;
import com.zlb.springboot_jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @PostMapping("/save")
    public String save(@RequestBody Person person) {
        personService.save(person);
        return "200";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        personService.deleteById(id);
        return "200";
    }

    @GetMapping("/findById/{id}")
    public Person findById(@PathVariable Long id) {
        return personService.findPerson(id);
    }

    @GetMapping("/findAll")
    public List<Person> findAll() {
        return personService.findPerson();
    }

    @PatchMapping("/update")
    public String update(@RequestBody Person person) {
        personService.update(person);
        return "200";
    }


    @PostMapping("/save2")
    public Person save(String name, String address, Integer age) {
        Person person = new Person(null, name, age, address);
        personService.save(person);
        return person;
    }

    /**
     * 测试findByAddress
     */
    @GetMapping("/findbyaddress")
    public List<Person> findByAddress(String address) {
        List<Person> list = personService.findByAddress(address);
        return list;
    }

    /**
     * 根据name 和 address 查询
     *
     * @param name
     * @param address
     * @return
     */
    @GetMapping("/findbyna")
    public Person findByNameAndAddress(String name, String address) {
        Person person = personService.findPersonByNameAndAddress(name, address);
        return person;
    }

    /**
     *   根据name 和 address 查询
     * @param name
     * @param address
     * @return person
     */
    @GetMapping("withna")
    public Person withNameAndAddress(String name, String address) {
        return personService.withNameAndAddress(name, address);
    }

    /**
     *   根据name 和 address 查询
     * @param name
     * @param address
     * @return person
     */
    @GetMapping("withna2")
    public Person withNameAndAddressQuery(String name, String address) {
        return personService.withNameAndAddressQuery(name, address);
    }

    /**
     * 测试自带排序
     * @return
     */
    @GetMapping("/sort")
    public List<Person> sort(){

        return personService.sort();
    }

    /**
     * 测试分页
     * @return
     */
    @GetMapping("/page")
    public Page<Person> personPage(){
        return personService.page();
    }
}
