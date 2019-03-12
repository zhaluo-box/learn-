package com.zlb.springboot_jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean  //这个接口不被
public interface BaseDao<T,ID extends Serializable> extends JpaRepository<T , ID > , JpaSpecificationExecutor<T> {


}
