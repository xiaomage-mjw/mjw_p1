package com.i2f.springboot.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 8:51 2022/9/24
 */
@Data
@AllArgsConstructor
public class ResultModel<T> {
    private String code;
    private String msg;
    private T data;
}
