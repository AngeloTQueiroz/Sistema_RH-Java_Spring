package com.AppRH.AppRH.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "✅ App está funcionando! IP: 192.168.1.74:8080";
    }
}