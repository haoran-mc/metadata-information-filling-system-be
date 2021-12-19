package com.metadata.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

// jwt工具类
@Component
@ConfigurationProperties(prefix = "haoran.jwt")
public class JwtUtils {

    private String secret;
    private long expire;
    private String header;

    // 生成jwt token
    public String generateToken(long userId) {
        Date nowDate = new Date();
        // 过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(userId+"")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims getClaimByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            // log.debug("validate is token error ", e);
            return null;
        }
    }

    // 判断 token 是否过期，如果过期就返回 true
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }
}
