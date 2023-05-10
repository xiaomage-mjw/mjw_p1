package com.i2f.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 9:01 2022/9/24
 */
@Data
public class PersonInfo {
    /**
    * description:  姓名
    **/
    private String name;
    /**
     * description:  求职意向
     **/
    private String jobIntention;
    /**
     * description:  性别
     **/
    private String sex;
    /**
     * description:  民族
     **/
        private String nation;
    /**
     * description:  政治面貌
     **/
    private String politicFace;
    /**
     * description:  出生日期
     **/
    @Value("hhhh")
    private String birthday;
    /**
     * description:  婚姻状况
     **/
    private String maritalStatus;
    /**
     * description:  籍贯
     **/
    private String nativePlace;
    /**
     * description:  居住地
     **/
    private String addr;
    /**
     * description:  健康状况
     **/
    private String healthStatus;
    /**
     * description:  手机号码
     **/
    private String phone;
    /**
     * description:  电子邮箱
     **/
    private String mailbox;
    /**
     * description:  特长爱好
     **/
    private String hobby;

    public PersonInfo(String name, String jobIntention, String sex, String nation, String politicFace, String maritalStatus, String nativePlace, String addr, String healthStatus, String phone, String mailbox, String hobby) {
        this.name = name;
        this.jobIntention = jobIntention;
        this.sex = sex;
        this.nation = nation;
        this.politicFace = politicFace;
        this.maritalStatus = maritalStatus;
        this.nativePlace = nativePlace;
        this.addr = addr;
        this.healthStatus = healthStatus;
        this.phone = phone;
        this.mailbox = mailbox;
        this.hobby = hobby;
    }
}
