package com.qy.demo;

import com.alibaba.excel.EasyExcel;
import com.qy.entity.User;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author QianSiWang
 * @Date 2022/11/5 10:50
 * @Description
 */
public class Demo1 {
    public List<User> getUser(){
        List<User> users = new ArrayList<User>();
        for(int i = 0 ;i< 5;i++){

            users.add(new User("钱思惘"+i,i,"踢足球"+i));
        }
        return users;
    }

    /**
     * 写测试
     */
    @Test
    public void exportTest(){
        String fileName = "E:\\tempCanBeDeleted\\write" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, User.class).sheet("模板").doWrite(getUser());

    }
    /**
     * 读测试
     */
    @Test
    public void importTest() throws FileNotFoundException {
        String fileName = "E:\\tempCanBeDeleted\\write" + "1667616932702" + ".xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        List<User> objects = EasyExcel.read(new FileInputStream(fileName)).head(User.class).sheet().headRowNumber(1).doReadSync();
        System.out.println(objects);

    }
}
