package com.peluqueria.service;

import com.peluqueria.model.Cita;
import com.peluqueria.model.Peluquera;
import com.peluqueria.model.Usuario;
import com.peluqueria.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    public List<Cita> listarCitasPorUsuario(Usuario usuario) {
        return citaRepository.findByUsuario(usuario);
    }

    public List<Cita> listarCitasPorPeluquera(Peluquera peluquera) {
        return citaRepository.findByPeluquera(peluquera);
    }

    public Optional<Cita> buscarPorId(Long id) {
        return citaRepository.findById(id);
    }

    public boolean existeCita(Peluquera peluquera, LocalDateTime fechaHora) {
        return citaRepository.existsByPeluqueraAndFechaHora(peluquera, fechaHora);
    }

    public Cita agendarCita(Cita cita) {
        if (existeCita(cita.getPeluquera(), cita.getFechaHora())) {
            throw new RuntimeException("Este horario ya está ocupado.");
        }
        return citaRepository.save(cita);
    }

    public void cancelarCita(Long id) {
        citaRepository.deleteById(id);
    }
}
