import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

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
public class TestJJWT3 {
    @Test
    public void createJWT(){
        //当前时间
        long currentTimeMillis = System.currentTimeMillis();
        currentTimeMillis+=1000000L;
        Date date = new Date(currentTimeMillis);
        JwtBuilder builder= Jwts.builder()
                .setId("888")   //设置唯一编号
                .setSubject("小白")//设置主题  可以是JSON数据
                .setIssuedAt(new Date())//设置签发日期
                .setExpiration(date)//设置过期时间
                .claim("roles","admin")//设置角色
                .signWith(SignatureAlgorithm.HS256,"ydlershe");//设置签名 使用HS256算法，并设置SecretKey(字符串)
        //构建 并返回一个字符串
        System.out.println( builder.compact() );
    }
    
    }

