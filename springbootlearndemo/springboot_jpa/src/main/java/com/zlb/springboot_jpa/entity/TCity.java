package com.zlb.springboot_jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "t_city", schema = "test", catalog = "")
public class TCity implements Serializable {

    private static final long serialVersionUID = 3355388752632085541L;
    private int id;
    private String country;
    private String map;
    private String name;
    private String state;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "country", nullable = true, length = 255)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "map", nullable = true, length = 255)
    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "state", nullable = true, length = 255)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TCity tCity = (TCity) o;
        return id == tCity.id &&
                Objects.equals(country, tCity.country) &&
                Objects.equals(map, tCity.map) &&
                Objects.equals(name, tCity.name) &&
                Objects.equals(state, tCity.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, map, name, state);
    }
}
