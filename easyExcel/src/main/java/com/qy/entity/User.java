package com.qy.entity;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author QianSiWang
 * @Date 2022/11/5 10:49
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @ExcelProperty("鼎鼎大名")
    private String name;

    @ExcelProperty("今昔几何")
    private int age;

    @ExcelProperty("喜闻乐见")
    private String hobby;

}
