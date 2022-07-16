package com.atguigu.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author dpy
 * @create 2022-07-16 13:27
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment implements Serializable {
    private long id;
    private String serial;
}
