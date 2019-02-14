package com.zlb.springboot_jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "t_hotel", schema = "test", catalog = "")
public class THotel implements Serializable {

    private static final long serialVersionUID = -988959006239477167L;
    private int id;
    private String address;
    private String city;
    private String name;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 255)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        THotel tHotel = (THotel) o;
        return id == tHotel.id &&
                Objects.equals(address, tHotel.address) &&
                Objects.equals(city, tHotel.city) &&
                Objects.equals(name, tHotel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, city, name);
    }
}
