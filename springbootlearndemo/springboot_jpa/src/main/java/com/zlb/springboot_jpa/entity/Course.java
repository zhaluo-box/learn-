package com.zlb.springboot_jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Course implements Serializable {


    private static final long serialVersionUID = 226253639673423617L;
    private String id;
    private String cName;
    private String tId;

    @Id  //主键
//  @GeneratedValue 主键生成策略
    @Column(name = "id", nullable = false, length = 20)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "c_name", nullable = false, length = 20)
    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Basic
    @Column(name = "t_id", nullable = false, length = 20)
    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) &&
                Objects.equals(cName, course.cName) &&
                Objects.equals(tId, course.tId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cName, tId);
    }
}
