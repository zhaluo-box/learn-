package com.zlb.springboot_jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //1
@NamedQuery(name="Person.withNameAndAddressQuery2",query = "select p from Person p where p.name = ?1 and p.address = ?2")
public class Person implements Serializable {

    private static final long serialVersionUID = 5918727834473026681L;

    @Id //2
    @GeneratedValue //3
    private Long id;

    private String name;

    private Integer age;

    private String address;

}

