package com.example.Agence.controller;

import com.example.Agence.DTO.ComparateurDTO;
import com.example.Agence.DTO.OffreComparateurDTO;
import com.example.Agence.repository.HotelRepository;
import com.example.Agence.repository.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/comparateur")
public class OffreController {
    @Autowired
    private OffreRepository offreRepository;

    @PostMapping
    public List<OffreComparateurDTO> getOffre(@RequestBody ComparateurDTO comparateurDTO){
        return offreRepository.getOffre(comparateurDTO);
    }

    @GetMapping
    public  String HelloComparateur(){
        return "Hello from comparateur";
    }
}
