import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * Project Name: ydles_parent
 * File Name: TestJJWT2
 *
 * @version 1.0
 * @author:wenerduo
 * @Date: 2022/01/18/上午 10:25
 * Copyright (c) 2022,
 */
public class TestJJWT2 {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        JwtBuilder builder= Jwts.builder()
                .setId("888")   //设置唯一编号
                .setSubject("小白")//设置主题  可以是JSON数据
                .setIssuedAt(new Date())//设置签发日期
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS256,"ydlershe");//设置签名 使用HS256算法，并设置SecretKey(字符串)
//构建 并返回一个字符串

        System.out.println( builder.compact() );
        String compactJwt="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE1NTc5MDUzMDgsImV4cCI6MTU1NzkwNTMwOH0.4q5AaTyBRf8SB9B3Tl-I53PrILGyicJC3fgR3gWbvUI";

        Claims claims = Jwts.parser().setSigningKey("ydlershe").parseClaimsJws(compactJwt).getBody();

        System.out.println(claims);
    }
}
