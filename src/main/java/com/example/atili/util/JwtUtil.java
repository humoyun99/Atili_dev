package com.example.atili.util;

import com.example.atili.dto.JwtDTO;
import com.example.atili.enums.ProfileRole;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
public class JwtUtil  {

    private static final int tokenLifeTime = 60 * 60 * 24 * 7;// 7-Days
    private static final String secretKey = "Atilie";

    public static String encode(String email, ProfileRole role) {
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.signWith(SignatureAlgorithm.ES512, secretKey);

        jwtBuilder.claim("email", email);
        jwtBuilder.claim("role", role);

        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + tokenLifeTime));
        jwtBuilder.setIssuer("Atilie test shop");
        return jwtBuilder.compact();
    }
    public static String encode(String phone, List<ProfileRole> roles) {
        String roleStr = "";
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.signWith(SignatureAlgorithm.HS512, secretKey);

        jwtBuilder.claim("phone", phone);

        for (int i = 0; i < roles.size(); i++) {
            if(i == roles.size()-1){
                roleStr = roleStr + roles.get(i);
            }else
                roleStr = roleStr + roles.get(i) +", ";
        }

        jwtBuilder.claim("roles", roleStr);


        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + (tokenLifeTime)));
        jwtBuilder.setIssuer("kitabu  test portali");
        return jwtBuilder.compact();
    }
    public static String encode(Integer profileId) {
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.signWith(SignatureAlgorithm.HS512, secretKey);

        jwtBuilder.claim("id", profileId);
        int tokenLifeTime = 1000 * 3600 * 24; // 1-day
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + (tokenLifeTime)));
        jwtBuilder.setIssuer("Mazgi");

        return jwtBuilder.compact();
    }
    public static String encode(Integer profileId, String email) {
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.signWith(SignatureAlgorithm.HS512, secretKey);

        jwtBuilder.claim("id", profileId);
        jwtBuilder.claim("email", email);
        int tokenLifeTime = 1000 * 3600 * 24; // 1-day
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + (tokenLifeTime)));
        jwtBuilder.setIssuer("Mazgi");

        return jwtBuilder.compact();
    }
    public static JwtDTO decode(String token) {
        JwtParser jwtParser = Jwts.parser();
        jwtParser.setSigningKey(secretKey);

        Jws<Claims> jws = jwtParser.parseClaimsJws(token);

        Claims claims = jws.getBody();

        String email = (String) claims.get("email");

        String role = (String) claims.get("role");
        ProfileRole profileRole = ProfileRole.valueOf(role);

        return new JwtDTO(email, profileRole);
    }
    public static String decodePhone(String token) {

        JwtParser jwtParser = Jwts.parser();
        jwtParser.setSigningKey(secretKey);

        Jws<Claims> jws = jwtParser.parseClaimsJws(token);

        Claims claims = jws.getBody();

//        Integer id = (Integer) claims.get("phone");
        return (String) claims.get("email");
    }
   /* public static JwtEmailChangeDTO decodeMailGetUserIdAndEmailAddress(String token) {

        JwtParser jwtParser = Jwts.parser();
        jwtParser.setSigningKey(secretKey);

        Jws<Claims> jws = jwtParser.parseClaimsJws(token);

        Claims claims = jws.getBody();

        Integer id = (Integer) claims.get("id");
        String email = (String) claims.get("login");

        return new JwtEmailChangeDTO(id,email);
    }
    */
}
