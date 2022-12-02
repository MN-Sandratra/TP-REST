package com.example.Agence.repository;

import com.example.Agence.DTO.ComparateurDTO;
import com.example.Agence.DTO.OffreComparateurDTO;
import com.example.Agence.DTO.OffreDTO;
import com.example.Agence.Data.AgenceData;
import com.example.Agence.models.Hotel;
import com.example.Agence.models.Offre;
import com.example.Agence.models.Webservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
