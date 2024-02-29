package com.cine.demo.services;

import com.cine.demo.entities.cineScape.Utilisateur;
import com.cine.demo.repositories.UtilisateurRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class AuthService {
    private Key secret = new SecretKeySpec(Base64.getDecoder().decode("secret"),
            SignatureAlgorithm.HS256.getJcaName());

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public ResponseEntity<Map<String, Object>> authenticate(String email, String password) {
        ResponseEntity<Map<String, Object>> result = ResponseEntity.ok(new HashMap<>());
        Optional<Utilisateur> userOptionnal = this.utilisateurRepository.findOneByEmail(email);
        if(userOptionnal.isPresent()){
            Utilisateur user = userOptionnal.get();
            if(authUser(user)){
                Map<String, Object> map = new HashMap<>();
                map.put("token", generateJwt(user));
                HashMap<String, String> userMap = new HashMap<>();
                userMap.put("email", user.getEmail());
                userMap.put("id", user.getId().toString());
                map.put("user", userMap);
                result = ResponseEntity.ok(map);
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


    private boolean authUser(Utilisateur user){
        return true;
    }


    private String generateJwt(Utilisateur user) {
        return Jwts.builder()
                .claim("id", user.getId())
                .claim("firstname", user.getFirstname())
                .claim("email", user.getEmail())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.HOURS)))
                .compact();
    }
}
