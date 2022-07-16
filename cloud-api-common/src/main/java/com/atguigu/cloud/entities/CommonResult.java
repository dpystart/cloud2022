package com.atguigu.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dpy
 * @create 2022-07-16 13:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T>{
    private Integer code;
    private String message;
    private T data;
    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
