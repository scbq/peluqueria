package com.peluqueria.controller;

import com.peluqueria.model.Peluquera;
import com.peluqueria.service.PeluqueraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peluqueras")
public class PeluqueraController {

    @Autowired
    private PeluqueraService peluqueraService;

    @GetMapping
    public List<Peluquera> listarPeluqueras() {
        return peluqueraService.listarPeluqueras();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Peluquera> buscarPeluquera(@PathVariable Long id) {
        Optional<Peluquera> peluquera = peluqueraService.buscarPorId(id);
        return peluquera.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Peluquera guardarPeluquera(@RequestBody Peluquera peluquera) {
        return peluqueraService.guardarPeluquera(peluquera);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPeluquera(@PathVariable Long id) {
        peluqueraService.eliminarPeluquera(id);
        return ResponseEntity.noContent().build();
    }
}
