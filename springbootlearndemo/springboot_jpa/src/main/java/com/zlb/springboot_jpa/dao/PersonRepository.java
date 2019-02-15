package com.zlb.springboot_jpa.dao;

import com.zlb.springboot_jpa.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SuppressWarnings("unused")
public interface PersonRepository extends BaseDao<Person, Long> {

    // 命名查询
    Person findPersonById(Long id);

    //使用方法名查询
    List<Person> findPersonByAddress(String address);

    //使用方法名查询
    Person findByNameAndAddress(String name, String Address);

    //@query查询 参数名称绑定
    @Query(value = "select  p from Person p where p.name = :name and p.address like  :address ")
    Person withNameAndAddressQuery(@Param("name") String name,@Param("address") String address);

    //@NameQueruy 在类上写的
    Person withNameAndAddressQuery2(String name, String address);
}
