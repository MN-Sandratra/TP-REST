package com.example.Agence.controller;

import com.example.Agence.Data.AgenceData;
import com.example.Agence.models.Agence;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agence")
public class AgenceController {
    @GetMapping
    public Agence getNom(){
        return AgenceData.getAgence();
    }
}
