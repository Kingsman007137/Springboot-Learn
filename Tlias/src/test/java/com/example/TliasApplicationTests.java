package com.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class TliasApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 生成JWT
     */
    @Test
    void testGenJWT() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", "1");
        claims.put("name", "Tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "kingsman")//指定签名算法
                .addClaims(claims)//自定义内容（Map 类型）
                .setExpiration(new Date(System.currentTimeMillis() + 3600*1000))//设置令牌有效期为1小时
                .compact();//字符串形式返回令牌
        System.out.println(jwt);
    }

    /**
     * 解析JWT
     */
    @Test
    void testParseJWT() {
        Claims claims = Jwts.parser()
                .setSigningKey("kingsman") //刚刚指定签名算法时用的字符串
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiVG9tIiwiaWQiOiIxIiwiZXhwIjoxNzA2MDY2MzE4fQ.W3d8lz4ni5J0a7ooD4J92-iDrx_rbpFxag57_tSk1BU")
                .getBody();
        System.out.println(claims);
    }
}
