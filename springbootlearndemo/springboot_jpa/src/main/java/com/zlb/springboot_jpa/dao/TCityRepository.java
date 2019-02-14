package com.zlb.springboot_jpa.dao;

import com.zlb.springboot_jpa.entity.TCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TCityRepository extends JpaRepository<TCity, Integer>, JpaSpecificationExecutor<TCity> {


}
