package com.zlb.springboot_jpa.dao;

public interface NameOnly {

    String  getUserName();
    String  getPassWord();

    public default String  toStrings(){
        return getUserName()+" " + getPassWord();
    }
}
