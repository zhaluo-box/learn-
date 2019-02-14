package com.zlb.springboot_jpa.dao;

import com.zlb.springboot_jpa.dto.StuAndScore;
import com.zlb.springboot_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {


    /*
    查询的结果
        {score=80, SSex=01, SName=男, SBirth=赵雷, id=01, CId=01, SId=1990-01-01}
        {score=70, SSex=02, SName=男, SBirth=钱电, id=01, CId=02, SId=1990-12-21}
        {score=80, SSex=03, SName=男, SBirth=孙风, id=01, CId=03, SId=1990-05-20}
        {score=50, SSex=04, SName=男, SBirth=李云, id=01, CId=04, SId=1990-08-06}
        {score=76, SSex=05, SName=女, SBirth=周梅, id=01, CId=05, SId=1991-12-01}
        {score=31, SSex=06, SName=女, SBirth=吴兰, id=01, CId=06, SId=1992-03-01}
     */
    @Query(value = "select s.* ,sc.* from student s left join score sc on" +
            " s.id=sc.s_id where sc.c_id='01' ",nativeQuery = true)
    List<StuAndScore> findlll();

    @Query(value = "select * from student s left join score sc on s.id=sc.s_id ",nativeQuery = true)
    List<StuAndScore> findAllsc();
}
