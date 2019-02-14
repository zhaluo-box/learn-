package com.zlb.springboot_jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(ScorePK.class)
public class Score implements Serializable {

    private static final long serialVersionUID = 447798020402701898L;
    private String sId;
    private String cId;
    private Integer sScore;

    @Id
    @Column(name = "s_id", nullable = false, length = 20)
    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    @Id
    @Column(name = "c_id", nullable = false, length = 20)
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Basic
    @Column(name = "s_score", nullable = true)
    public Integer getsScore() {
        return sScore;
    }

    public void setsScore(Integer sScore) {
        this.sScore = sScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return Objects.equals(sId, score.sId) &&
                Objects.equals(cId, score.cId) &&
                Objects.equals(sScore, score.sScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sId, cId, sScore);
    }
}
