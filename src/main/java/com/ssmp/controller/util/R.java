package com.ssmp.controller.util;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {
    private Boolean flag;
    private Object data;
    private String msg;


    public R(String msg){
        this.flag = false;
        this.msg = msg;
    }
    public R(Boolean flag){
        this.flag = flag;
    }
    public R(Boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }
    public R(Boolean flag,String msg){
        this.flag = flag;
        this.msg = msg;
    }

}
