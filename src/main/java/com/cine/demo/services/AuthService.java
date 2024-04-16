package com.cine.demo.services;

import com.cine.demo.entities.cineScape.Utilisateur;
import com.cine.demo.repositories.UtilisateurRepository;
import com.google.common.hash.Hashing;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class AuthService {
    private Key secret = new SecretKeySpec(Base64.getDecoder().decode("34dd36e949943cc11155a864cc4df88cd61f09cf1330fc07fa36f445ae6e133a"),
            SignatureAlgorithm.HS256.getJcaName());

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public ResponseEntity<Map<String, Object>> authenticate(String email, String password) {
        ResponseEntity<Map<String, Object>> result;
        Optional<Utilisateur> userOptionnal = this.utilisateurRepository.findByEmail(email);

        if(userOptionnal.isPresent()){
            Utilisateur user = userOptionnal.get();
            if(authUser(user, password)){
                Map<String, Object> mapResult = new HashMap<>();
                mapResult.put("token", generateJwt(user));
                mapResult.put("user", user);
                result = ResponseEntity.ok(mapResult);
            } else {
                Map<String, Object> map = new HashMap<>();
                map.put("error", "password doesn't match");
                result = ResponseEntity.ok(map);
            }
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("error", "email not found");
            result = ResponseEntity.ok(map);
        }
        return result;
    }


    private boolean authUser(Utilisateur user, String password){
        boolean isConnected = false;
        String hashPassword = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        if(Objects.equals(user.getPassword(), hashPassword)){
            isConnected = true;
        }
        return isConnected;
    }


    private String generateJwt(Utilisateur user) {
        return Jwts.builder()
                .claim("id", user.getId())
                .claim("firstname", user.getFirstname())
                .claim("email", user.getEmail())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.HOURS)))
                .signWith(this.secret)
                .compact();
    }
}
