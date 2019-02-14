package com.zlb.springboot_jpa.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ScorePK implements Serializable {


    private static final long serialVersionUID = 4009076899174253317L;
    private String sId;
    private String cId;

    @Column(name = "s_id", nullable = false, length = 20)
    @Id
    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    @Column(name = "c_id", nullable = false, length = 20)
    @Id
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScorePK scorePK = (ScorePK) o;
        return Objects.equals(sId, scorePK.sId) &&
                Objects.equals(cId, scorePK.cId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sId, cId);
    }
}
