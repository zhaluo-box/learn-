package com.zlb.springboot_jpa.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 5845363935667601269L;
    private String id;
    private String sName;
    private String sBirth;
    private String sSex;

    @Id
    @Column(name = "id", nullable = false, length = 20)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "s_name", nullable = false, length = 20)
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Basic
    @Column(name = "s_birth", nullable = false, length = 20)
    public String getsBirth() {
        return sBirth;
    }

    public void setsBirth(String sBirth) {
        this.sBirth = sBirth;
    }

    @Basic
    @Column(name = "s_sex", nullable = false, length = 10)
    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(sName, student.sName) &&
                Objects.equals(sBirth, student.sBirth) &&
                Objects.equals(sSex, student.sSex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sName, sBirth, sSex);
    }
}
