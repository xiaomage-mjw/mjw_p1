package com.i2f.springboot.annoation;

import java.lang.annotation.*;

/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 20:57 2022/10/25
 */
@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataBindJudge {
    String value();
}
