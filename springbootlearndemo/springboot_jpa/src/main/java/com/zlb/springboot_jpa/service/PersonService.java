package com.zlb.springboot_jpa.service;

import com.zlb.springboot_jpa.entity.Person;
import org.springframework.data.domain.Page;

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

    /**
     * 根据address 查询person.
     * @param address
     * @return
     */
    List<Person> findByAddress(String address);

    /**
     * findPersonByNameAndAddress
     *
     * @param name
     * @param address
     * @return person
     */
    Person findPersonByNameAndAddress(String name, String address);

    /**
     * withNameAndAddress
     *
     * @param name
     * @param address
     * @return person
     */
    Person withNameAndAddress(String name, String address);

    /**
     * withNameAndAddressQuery
     *
     * @param name
     * @param address
     * @return person
     */
    Person withNameAndAddressQuery(String name, String address);

    /**
     * 按年龄排序
     * @return
     */
    List<Person> sort();

    Page<Person> page();
}
