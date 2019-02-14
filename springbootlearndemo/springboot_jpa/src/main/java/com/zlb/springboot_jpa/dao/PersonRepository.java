package com.zlb.springboot_jpa.dao;

import com.zlb.springboot_jpa.entity.Person;


public interface PersonRepository extends BaseDao<Person, Long> {

    // 命名查询
    Person findPersonById(Long id);

}
