package com.zlb.springboot_jpa.dto;


/**
 * 结果集映射接口
 */
@SuppressWarnings("unused")
public interface StuAndScore {

    /* student */
    String getId();

    String getSName();

    String getSBirth();

    String getSSex();

    /* score */
    String getSId();

    String getCId();

    Integer getScore();

}
