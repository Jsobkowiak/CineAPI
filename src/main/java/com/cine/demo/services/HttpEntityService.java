package com.cine.demo.services;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.http.HttpHeaders;

public class HeaderService {

    public static HttpHeaders createHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", Dotenv.load().get("API_ACCESS_TOKEN"));
        headers.set("accept", "application/json");
        return headers;
    }
}
