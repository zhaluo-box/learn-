package com.zlb.springboot_jpa.service;

import com.zlb.springboot_jpa.entity.Person;

import java.util.List;

public interface PersonService {

    //添加
    void save(Person person);

    //删除ById
    void deleteById(Long id);

    //修改
    void update(Person person);

    //查找ById
    Person findPerson(Long id);

    //查询所有
    List<Person> findPerson();

}
