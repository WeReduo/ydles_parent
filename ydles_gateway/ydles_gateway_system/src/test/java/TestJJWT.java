import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * Project Name: ydl_parent
 * File Name: TestJJWT
 *
 * @version 1.0
 * @author:wenerduo
 * @Date: 2022/01/18/上午 10:12
 * Copyright (c) 2022,
 */
public class TestJJWT {
    public static void main(String[] args) {
        //获取系统的当前时间
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);

        //生成jwt令牌
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("66")//设置jwt编码
                .setSubject("元动力二奢")//设置jwt主题
                .setIssuedAt(new Date())//设置jwt签发日期
                //.setExpiration(date)//设置jwt的过期时间
                .signWith(SignatureAlgorithm.HS256, "ydlershe");

        //生成jwt
        String jwtToken2 = jwtBuilder.compact();
        System.out.println(jwtToken2);

        String compactJwt="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyNyIsInN1YiI6InlkbGVyc2hlc2hhbmdjaGVuZyIsImlhdCI6MTYzNDYzMjMyNn0.orvxPJcAsOquRjcjj947vMmD11QoZn8BuHKSeCEbV8g";

        Claims claims = Jwts.parser().setSigningKey("ydlershe").parseClaimsJws(compactJwt).getBody();

        System.out.println(claims);
    }
    }

