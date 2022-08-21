package com.qy.easypoi.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author QianSiWang
 * @Date 2022/8/8 18:21
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Excel(name = "姓名")
    private String name;

    @Excel(name = "年龄")
    private int age;

    @Excel(name = "爱好")
    private String hobby;
}
