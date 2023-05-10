package com.i2f.springboot.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.i2f.springboot.annoation.DataBindJudge;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.AliasFor;

import javax.persistence.*;

/**
 * tbl_user
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="tbl_user")
public class User implements Serializable {
    /**
     * 用户编号
     */
    @DataBindJudge(value = "用户编号输入非法")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名称
     */
    @DataBindJudge(value = "用户姓名输入非法")
    @Column
    @Value("${name}")
    private String name;

    /**
     * 性别
     */
    @DataBindJudge(value = "性别输入非法")
    @Column
    private String sex;

    /**
     * 年龄
     */
    @Column
    private String age;

    /**
     * 支付密码
     */
    @Column
    private String password;

    /**
     * 账户余额
     */
    @Column
    private String money;

    private String date;

    //private List<PersonInfo> infoList;

    private static final long serialVersionUID = 1L;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
}