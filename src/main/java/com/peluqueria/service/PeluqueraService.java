package com.peluqueria.service;

import com.peluqueria.model.Peluquera;
import com.peluqueria.repository.PeluqueraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeluqueraService {

    @Autowired
    private PeluqueraRepository peluqueraRepository;

    public List<Peluquera> listarPeluqueras() {
        return peluqueraRepository.findAll();
    }

    public Optional<Peluquera> buscarPorId(Long id) {
        return peluqueraRepository.findById(id);
    }

    public Peluquera guardarPeluquera(Peluquera peluquera) {
        return peluqueraRepository.save(peluquera);
    }

    public void eliminarPeluquera(Long id) {
        peluqueraRepository.deleteById(id);
    }
}
