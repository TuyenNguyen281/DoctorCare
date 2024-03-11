package com.example.prj321x_project3_tuyenndfx29367.security.jwt;

import com.example.prj321x_project3_tuyenndfx29367.security.userdetail.UserPrinciple;

import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private String jwtSecret = "Tuyendqwerty";
    private int jwtExpiration = 86400;

    public String createToken(Authentication authentication) {
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(userPrinciple.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpiration*1000))
                .signWith(SignatureAlgorithm.HS512,jwtSecret).compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            System.out.println("Ivalid Jwt sinature ->Message: {}" + e);
        } catch (MalformedJwtException e) {
            System.out.println("the token invalid format ->Message: {}" + e);
        } catch (UnsupportedJwtException e) {
            System.out.println("Unsupported Jwt token->Message: {}" + e);
        } catch (ExpiredJwtException e) {
            System.out.println("Expried Jwt token ->Message: {}" + e);
        } catch (IllegalArgumentException e) {
            System.out.println("Jwt claims string is empty ->Message: {}" + e);
        }
        return false;
    }

    public String getUserNameFromJwtToken (String token) {
        String userName = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
        return userName;
    }

}
