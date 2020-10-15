package com.example.autowiredemo;

import com.example.autowiredemo.FortuneService;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Database fortune !!";
    }
}

