package com.qy.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author QianSiWang
 * @Date 2022/11/1 19:29
 * @Description
 */
public class FastJsonTest {
    @Test
    public void fastJsonTest01() {
        String string = JSON.toJSONString(new User("钱誉", 24));
        System.out.println("对象序列化" + string);
        User user = JSONObject.parseObject(string, User.class);
        System.out.println(user);

        List<User> users = new ArrayList<>();
        users.add(new User("张三", 14));
        users.add(new User("李四", 28));
        String string1 = JSON.toJSONString(users);
        System.out.println("集合序列化" + string1);
        List<User> users1 = JSONObject.parseArray(string1, User.class);
        System.out.println(users1);

    }
}
