package com.qy.md5;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

/**
 * @Author QianSiWang
 * @Date 2022/8/21 22:12
 * @Description
 */
public class MD5Test {
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        /*
                <!--  md5加密包      -->
        <dependency>
            <groupId>commons-codec</groupId>
            <artifactId>commons-codec</artifactId>
            <version>1.10</version>
        </dependency>
         */
        //直接导包使用MD5加密，使用约定好的key
        String send = DigestUtils.md5Hex(uuid+"key:qianyu");
        System.out.println(send);
        //验证的时候就是不传key，接收方使用同样的key验证
        String receive = DigestUtils.md5Hex(uuid+"key:qianyu");
        System.out.println(send.equalsIgnoreCase(receive));
    }
}
