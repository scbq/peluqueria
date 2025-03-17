package com.peluqueria.repository;

import com.peluqueria.model.Cita;
import com.peluqueria.model.Peluquera;
import com.peluqueria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByUsuario(Usuario usuario);

    List<Cita> findByPeluquera(Peluquera peluquera);

    boolean existsByPeluqueraAndFechaHora(Peluquera peluquera, LocalDateTime fechaHora);
}
