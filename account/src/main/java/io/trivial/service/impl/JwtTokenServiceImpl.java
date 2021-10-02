package io.trivial.service.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.trivial.service.JwtTokenService;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    @Override
    public String createNewToken() {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        return Jwts
                .builder()
                .setSubject("Joe")
                .signWith(key)
                .compact();
    }
}
