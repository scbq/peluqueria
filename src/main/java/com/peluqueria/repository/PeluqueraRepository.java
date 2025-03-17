package com.peluqueria.repository;

import com.peluqueria.model.Peluquera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeluqueraRepository extends JpaRepository<Peluquera, Long> {
}
