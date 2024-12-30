package edu.tute.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    // 秘钥
    private static final String SECRET_KEY = "tute";
    // 令牌过期时间，设置为2小时（以毫秒为单位）
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 2;

    /**
     * 生成JWT令牌，使用提供的声明，并设置过期时间。
     *
     * @param claims 要添加到令牌中的声明映射。
     * @return 生成的JWT令牌字符串。
     */
    public static String generateToken(Map<String, Object> claims) {

        Date expiryDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // 使用HS256算法和秘钥进行签名
                .addClaims(claims)                              // 添加自定义信息
                .setExpiration(expiryDate)                      // 设置令牌的过期时间
                .compact();                                     // 生成令牌
    }

    /**
     * 解析JWT令牌并返回其中包含的声明。
     *
     * @param token 要解析的JWT令牌。
     * @return 令牌中包含的声明。
     * @throws Exception 如果令牌无效或无法解析时抛出异常。
     */
    public static Claims parseToken(String token) throws Exception {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)      // 设置签名秘钥
                .parseClaimsJws(token)          // 解析JWT令牌
                .getBody();                     // 获取令牌中的声明
    }
}