package com.example.Hotel.repositories;

import com.example.Hotel.model.hotel.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}
